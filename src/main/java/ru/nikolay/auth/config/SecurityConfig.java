package ru.nikolay.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/login.html", "/css/**", "/js/**").permitAll() // Разрешаем доступ к login и статике
                        .anyRequest().authenticated() // Остальные запросы требуют аутентификации
                )
                .formLogin(form -> form
                        .loginPage("/login") // Говорим Spring'у использовать наш кастомный login.html
                        .loginProcessingUrl("/login") // Куда отправляется форма для обработки логина
                        .defaultSuccessUrl("/home", true) // Куда перекидывать после успешного входа
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }
}
