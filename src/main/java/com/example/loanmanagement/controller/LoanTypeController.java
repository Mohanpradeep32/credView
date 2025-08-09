package com.example.loanmanagement.controller;

import com.example.loanmanagement.model.LoanType;
import com.example.loanmanagement.service.loanTypeService.LoanTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-types")
public class LoanTypeController {

    @Autowired
    private  LoanTypeService loanTypeService;

    @GetMapping
    public List<LoanType> getLoanTypes() {
        return loanTypeService.getAllLoanTypes();
    }

    @GetMapping("/getByName")
    public LoanType getLoanTypesByName(@RequestParam String name) {
        return loanTypeService.getLoanTypeByName(name);
    }
}
