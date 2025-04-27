package ru.nikolay.auth.service;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 27.04.2025
// ⏰ Время создания: 6:11
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.nikolay.auth.model.Auth;
import ru.nikolay.auth.repository.AuthRepository;

@Service
public class AuthService {

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private AuthRepository authRepository;

    public Auth findUserByLogin(String playerId) {
        return authRepository.findByPlayerId(playerId);
    }
    public boolean checkPassword(String rawPassword,String storedPasswordHash) {
        return passwordEncoder.matches(rawPassword,storedPasswordHash);
    }
    public boolean login(String playerId,String password) {
        Auth user = findUserByLogin(playerId);
        if(user == null)
        {
            return false; //Нет такого пользователя
        }
        if(!checkPassword(password,user.getPasswordHash()))
        {
            return false; //Неверный пароль
        }
        return true;
    }

}
