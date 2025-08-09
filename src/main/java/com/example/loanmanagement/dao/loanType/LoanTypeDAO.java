package com.example.loanmanagement.dao.loanType;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanmanagement.model.LoanType;

public interface LoanTypeDAO extends JpaRepository<LoanType, Long> {
    
}
