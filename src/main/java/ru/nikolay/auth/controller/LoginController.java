package ru.nikolay.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/corpLogin")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if(error != null)
        {
            model.addAttribute("error", "Неверный логин или пароль");

        }
        return "corpLogin"; // просто возвращает страницу входа
    }
    @GetMapping("profile")
    public String profilePage() {
        return "profile";
    }
    @GetMapping("error")
    public String errorPage() {
        return "error";
    }
}

