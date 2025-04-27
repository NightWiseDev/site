package ru.nikolay.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/corpLogin", "/api/corpLogin").permitAll() // ДОБАВИЛ /api/corpLogin
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/corpLogin") // форма логина
                        .defaultSuccessUrl("/profile", true) // куда редиректить после успеха
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }
}
