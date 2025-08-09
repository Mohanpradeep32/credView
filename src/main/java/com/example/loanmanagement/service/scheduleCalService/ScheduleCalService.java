package com.example.loanmanagement.service.scheduleCalService;

import java.util.List;

import com.example.loanmanagement.model.LoanRequest;
import com.example.loanmanagement.model.RepaymentSchedule;

public interface ScheduleCalService {
    List<RepaymentSchedule> calculateSchedule(LoanRequest lr);
    
}
