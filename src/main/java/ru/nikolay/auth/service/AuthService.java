package ru.nikolay.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;
import ru.nikolay.auth.model.User;
import ru.nikolay.auth.repository.UserRepository;
import ru.nikolay.auth.security.CustomUserDetails;

import java.util.Collection;
import java.util.Collections;

@Service
public class AuthService {

    // Цвета для консоли (ANSI escape codes)
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public User findUserByLogin(String playerId) {
        System.out.println(PURPLE + "[AuthService] 🔍 Поиск пользователя: " + playerId + RESET);
        return userRepository.findByPlayerId(playerId);
    }

    public boolean checkPassword(String rawPassword, String storedPasswordHash) {
        logger.debug(CYAN + "[AuthService] 🔑 Проверка пароля..." + RESET);
        logger.debug(YELLOW + "  ➡️ Введённый пароль: " + rawPassword + RESET);
        logger.debug(YELLOW + "  ➡️ Хеш в базе: " + storedPasswordHash + RESET);

        boolean matches = passwordEncoder.matches(rawPassword, storedPasswordHash);
        if (matches) {
            logger.debug(GREEN + "  ✅ Пароль совпадает!" + RESET);
        } else {
            logger.debug(RED + "  ❌ Пароль не совпадает!" + RESET);
        }

        return matches;
    }

    public boolean login(String playerId, String password) {
        logger.debug(BLUE + "[AuthService] 🚪 Попытка входа для логина: " + playerId + RESET);

        User user = findUserByLogin(playerId);
        if (user == null) {
            logger.debug(RED + "[AuthService] ❌ Пользователь не найден!" + RESET);
            userRepository.findAll().forEach(user1 -> logger.debug(user1.getPlayerId()));
            return false;
        }

        boolean passwordCorrect = checkPassword(password, user.getPasswordHash());
        if (!passwordCorrect) {
            logger.debug(RED + "[AuthService] ❌ Неверный пароль!" + RESET);
            return false;
        }

        // ✅ Теперь создаём полноценного UserDetails
        CustomUserDetails userDetails = new CustomUserDetails(user);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        System.out.println(GREEN + "[AuthService] ✅ Успешная авторизация для пользователя: " + playerId + RESET);
        return true;
    }
}