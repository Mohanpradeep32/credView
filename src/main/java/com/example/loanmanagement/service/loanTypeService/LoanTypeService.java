package com.example.loanmanagement.service.loanTypeService;

import java.util.List;
import com.example.loanmanagement.model.LoanType;

public interface LoanTypeService {
    List<LoanType> getAllLoanTypes();

    LoanType getLoanTypeByName(String name);
}
