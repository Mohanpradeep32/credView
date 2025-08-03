package com.example.loanmanagement.controller;

import com.example.loanmanagement.model.Customers;
import com.example.loanmanagement.service.customerservice.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class CustomerController {

    @Autowired
    private CustomerService userService;

    // ✅ Serve HTML login page
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("user", new Customers());
        return "login"; // returns login.html (Thymeleaf)
    }

    // ✅ Serve HTML registration page
    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("user", new Customers());
        return "register"; // returns register.html (Thymeleaf)
    }

    // ✅ Handle JSON registration (for Postman/React)
    @PostMapping("/api/register")
    @ResponseBody
    public ResponseEntity<String> registerApi(@RequestBody Customers user) {
        Customers registered = userService.register(user);
        return ResponseEntity.ok(registered != null ? "Registered successfully" : "Username already exists");
    }

    // ✅ Handle JSON login (for Postman/React)
    @PostMapping("/api/login")
    @ResponseBody
    public ResponseEntity<String> loginApi(@RequestBody Customers user) {
        boolean loggedIn = userService.login(user.getUsername(), user.getPassword());
        return ResponseEntity.ok(loggedIn ? "Login successful" : "Invalid credentials");
    }

    // ✅ Handle form-based registration (from HTML form)
    @PostMapping("/register")
    public String handleFormRegister(@ModelAttribute Customers user, Model model) {
        Customers registered = userService.register(user);
        if (registered != null) {
            model.addAttribute("message", "Registered successfully");
            return "login";
        } else {
            model.addAttribute("error", "Username already exists");
            return "register";
        }
    }

    // ✅ Handle form-based login (from HTML form)
    @PostMapping("/login")
    public String handleFormLogin(@ModelAttribute Customers user, Model model) {
        boolean loggedIn = userService.login(user.getUsername(), user.getPassword());
        if (loggedIn) {
            return "home"; // or whatever page comes after login
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
