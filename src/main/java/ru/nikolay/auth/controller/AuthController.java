package ru.nikolay.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.nikolay.auth.model.User;
import ru.nikolay.auth.model.LoginRequest;
import ru.nikolay.auth.repository.UserRepository;
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
    private UserRepository userRepository;

    @Autowired
    private AuthService authService;

    @GetMapping("/auth")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @PostMapping("/corpLogin")
    public String login(@ModelAttribute LoginRequest loginRequest) {
        boolean isLoginSuccessful = authService.login(loginRequest.getPlayerId(),loginRequest.getPassword());
        if (isLoginSuccessful) {
            return "redirect:/success";
        } else {
            return "redirect:/error";
        }
    }
}
