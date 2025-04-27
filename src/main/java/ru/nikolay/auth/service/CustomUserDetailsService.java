package ru.nikolay.auth.service;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 27.04.2025
// ⏰ Время создания: 20:42
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.nikolay.auth.model.User;
import ru.nikolay.auth.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String playerId) throws UsernameNotFoundException {
        User user = userRepository.findByPlayerId(playerId);
        if(user == null)
        {
            throw new UsernameNotFoundException("Пользователь не найден.");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getPlayerId())
                .password(user.getPasswordHash())
                .roles("USER")
                .build();
    }


}
