package com.example.loanmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // Loads home.html from templates
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Loads login.html
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; // Loads register.html
    }
}
