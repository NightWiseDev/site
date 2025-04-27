package ru.nikolay.auth.controller;

import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nikolay.auth.model.Auth;
import ru.nikolay.auth.model.LoginRequest;
import ru.nikolay.auth.repository.AuthRepository;
import ru.nikolay.auth.service.AuthService;

import java.util.List;

// ✨ Этот класс был создан Николасом
// 📅 Дата создания: 26.04.2025
// ⏰ Время создания: 2:33
// 🏢 Корпорация: ɴɪɢʜᴛᴡɪꜱᴇᴅᴇᴠ
@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private AuthService authService;

    @GetMapping("/auth")
    public List<Auth> getAllUsers() {
        return authRepository.findAll();
    }
    @PostMapping("/corpLogin")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        boolean isLoginSuccessful = authService.login(loginRequest.getPlayerId(),loginRequest.getPassword());
        if (isLoginSuccessful) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
