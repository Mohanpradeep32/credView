package com.example.loanmanagement.controller;

import com.example.loanmanagement.model.Loan;
import com.example.loanmanagement.service.loanservice.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;

    // ✅ Serve HTML page for loan application form
    @GetMapping("/apply")
    public String showLoanForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan-apply";  // load loan-apply.html from /templates
    }

    // ✅ Handle loan form submission from frontend
    @PostMapping("/apply")
    public String submitLoanForm(@ModelAttribute Loan loan, Model model) {
        // Loan created = loanService.applyLoan(loan);
        model.addAttribute("message", "Loan applied successfully!");
        return "loan-status"; // show confirmation page
    }

    // ✅ API: Apply for loan (Postman or React)
    @PostMapping("/api/apply")
    @ResponseBody
    public ResponseEntity<Loan> applyLoanApi(@RequestBody Loan loan) {
        Loan created = loanService.applyLoan(loan);
        return ResponseEntity.ok(created);
    }

    // ✅ API: Get loans for a user (Postman or React)
    @GetMapping("/api/user/{userId}")
    @ResponseBody
    public ResponseEntity<List<Loan>> getLoansApi(@PathVariable Long userId) {
        List<Loan> loans = loanService.getLoans(userId);
        return ResponseEntity.ok(loans);
    }

    // ✅ View loans for a user (HTML page)
    @GetMapping("/user/{userId}")
    public String showUserLoans(@PathVariable Long userId, Model model) {
        List<Loan> loans = loanService.getLoans(userId);
        model.addAttribute("loans", loans);
        return "loan-list"; // load loan-list.html with user's loans
    }
}
