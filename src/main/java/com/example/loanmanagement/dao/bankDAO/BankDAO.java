package com.example.loanmanagement.dao.bankDAO;

import com.example.loanmanagement.model.Bank;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDAO extends JpaRepository<Bank, Long> {
    
}
