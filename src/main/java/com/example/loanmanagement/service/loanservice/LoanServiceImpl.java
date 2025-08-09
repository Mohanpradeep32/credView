package com.example.loanmanagement.service.loanservice;

import com.example.loanmanagement.dao.loanDAO.LoanDAO;
import com.example.loanmanagement.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService{
    @Autowired
    private LoanDAO loanDAO;

    public Loan applyLoan(Loan loan) {
        loan.setStatus("PENDING");
        return loanDAO.save(loan);
    }

    public List<Loan> getLoans(Long id) {
        return loanDAO.findByCustomerId(id);
    }
}