package com.example.loanmanagement.service.customerservice;

import com.example.loanmanagement.model.Customers;


public interface CustomerService {

     Customers register(Customers user);
     boolean login(String username, String rawPassword);
}
