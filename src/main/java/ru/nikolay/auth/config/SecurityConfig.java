package ru.nikolay.auth.config;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 27.04.2025
// ⏰ Время создания: 8:56
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()  // Доступ без аутентификации
                        .anyRequest().authenticated()  // Все остальные URL требуют входа
                )
                .formLogin(form -> form
                        .loginPage("/login")           // Страница входа
                        .defaultSuccessUrl("/home")   // После успешного входа
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")  // После выхода
                        .permitAll()
                );

        return http.build();
    }
}
