package com.example.loanmanagement.service.loanservice;

import java.util.List;

import com.example.loanmanagement.model.Loan;

public interface LoanService {
	
	 Loan applyLoan(Loan loan);

	 List<Loan> getLoans(Long userId);

}
