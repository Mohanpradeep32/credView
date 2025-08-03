package com.example.loanmanagement.service.customerservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.loanmanagement.dao.customerDAO.CustomerDAO;
import com.example.loanmanagement.model.Customers;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO secUserDAO;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Customers register(Customers user) {
        if (secUserDAO.findByUsername(user.getUsername()) != null) {
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return secUserDAO.save(user);
    }

    public boolean login(String username, String rawPassword) {
    	Customers user = secUserDAO.findByUsername(username);
        return user != null && passwordEncoder.matches(rawPassword, user.getPassword());
    }
}
