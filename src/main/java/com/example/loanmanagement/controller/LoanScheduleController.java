package com.example.loanmanagement.controller;

import com.example.loanmanagement.model.LoanRequest;
import com.example.loanmanagement.model.RepaymentSchedule;
import com.example.loanmanagement.service.scheduleCalService.ScheduleCalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanScheduleController {

    @Autowired
    private ScheduleCalService scheduleCalService;

    @PostMapping("/calculateSchedule")
    public List<RepaymentSchedule> calculateSchedule(@RequestBody LoanRequest request) {
        return scheduleCalService.calculateSchedule(request);
    }
}
