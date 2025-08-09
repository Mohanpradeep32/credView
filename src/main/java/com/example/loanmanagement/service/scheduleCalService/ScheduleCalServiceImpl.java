package com.example.loanmanagement.service.scheduleCalService;

import com.example.loanmanagement.model.LoanRequest;
import com.example.loanmanagement.model.RepaymentSchedule;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleCalServiceImpl implements ScheduleCalService {

    public List<RepaymentSchedule> calculateSchedule(LoanRequest request) {
        List<RepaymentSchedule> schedule = new ArrayList<>();

        double monthlyRate = request.getInterestRate() / 100 / 12;
        double emi = (request.getLoanAmount() * monthlyRate * Math.pow(1 + monthlyRate, request.getTenure())) /
                     (Math.pow(1 + monthlyRate, request.getTenure()) - 1);

        double remainingBalance = request.getLoanAmount();
        LocalDate paymentDate = LocalDate.now().withDayOfMonth(Math.min(request.getRepayDay(), 28)); 

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        for (int i = 0; i < request.getTenure(); i++) {
            double interest = remainingBalance * monthlyRate;
            double principal = emi - interest;
            remainingBalance -= principal;

            schedule.add(new RepaymentSchedule(
                    paymentDate.format(formatter),
                    round(principal),
                    round(interest),
                    round(emi),
                    round(Math.max(remainingBalance, 0))
            ));

            paymentDate = paymentDate.plusMonths(1);
        }

        return schedule;
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
