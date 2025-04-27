package ru.nikolay.auth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikolay.auth.model.LoginRequest;
import ru.nikolay.auth.service.AuthService;

@RestController
@RequestMapping("/api")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private AuthService authService;

    @PostMapping("/corpLogin")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        logger.info("Запрос на логин: {}", loginRequest);

        boolean isLoginSuccessful = authService.login(loginRequest.getPlayerId(), loginRequest.getPassword());
        if (isLoginSuccessful) {
            logger.info("Логин успешен для пользователя: {}", loginRequest.getPlayerId());
            return ResponseEntity.ok("SUCCESS");
        } else {
            logger.error("Ошибка при логине для пользователя: {}", loginRequest.getPlayerId());
            return ResponseEntity.status(401).body("Неверный логин или пароль");
        }
    }
}
