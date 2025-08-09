package com.example.loanmanagement.service.loanTypeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loanmanagement.dao.loanType.LoanTypeDAO;
import com.example.loanmanagement.model.LoanType;

@Service
public class LoanTypeServiceImpl implements LoanTypeService{

    @Autowired
    private LoanTypeDAO loanTypeDAO;

    @Override
    public List<LoanType> getAllLoanTypes() {
       return loanTypeDAO.findAll();
    }
    
}
