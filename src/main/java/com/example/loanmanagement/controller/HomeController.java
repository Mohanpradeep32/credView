package com.example.loanmanagement.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.loanmanagement.model.Bank;
import com.example.loanmanagement.model.LoanType;
import com.example.loanmanagement.service.bankService.BankService;
import com.example.loanmanagement.service.loanTypeService.LoanTypeService;

@Controller
public class HomeController {

    @Autowired
    private BankService bankService;

    @Autowired
    private LoanTypeService loanTypeService;

    @GetMapping("/")
    public String home() {
        return "home"; 
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register"; 
    }

    @GetMapping("/contact")
    public String contact() {
        return "contactUs"; 
    }

    @GetMapping("/loanTypes")
    public String loanType(Model model) {
        List<LoanType> loanTypes = loanTypeService.getAllLoanTypes();
        model.addAttribute("loanTypes", loanTypes);
        return "loanType"; 
    }

    @GetMapping("/banks")    
    public String bank(Model model) {
        List<Bank> banks = bankService.getAllBanks();
        model.addAttribute("banks", banks);
        return "banks";
    }
}
