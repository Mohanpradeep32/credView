package com.example.loanmanagement.service.bankService;

import com.example.loanmanagement.dao.bankDAO.BankDAO;
import com.example.loanmanagement.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDAO bankDAO;

    @Override
    public List<Bank> getAllBanks() {
        return bankDAO.findAll();
    }
}
