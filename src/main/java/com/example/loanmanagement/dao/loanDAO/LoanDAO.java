package com.example.loanmanagement.dao.loanDAO;

import com.example.loanmanagement.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanDAO extends JpaRepository<Loan, Long> {
    List<Loan> findByCustomerId(Long id);
}