package ru.nikolay.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/corpLogin")
    public String login() {
        return "corpLogin"; // просто возвращает страницу входа
    }
}

