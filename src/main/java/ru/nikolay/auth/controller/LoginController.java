package ru.nikolay.auth.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Authenticator;

@Controller
public class LoginController {

    @GetMapping("/corpLogin")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        return "corpLogin"; // просто возвращает страницу входа
    }
    @GetMapping("/profile")
    public String profilePage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String playerId = auth.getName();

        model.addAttribute("playerId", playerId);
        model.addAttribute("avatarUrl","/resources/static/images/avatar.png");

        return "profile";
    }
    @GetMapping("error")
    public String errorPage() {
        return "error";
    }
}

