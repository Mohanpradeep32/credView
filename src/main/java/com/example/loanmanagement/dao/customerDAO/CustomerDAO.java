package com.example.loanmanagement.dao.customerDAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loanmanagement.model.Customers;

public interface CustomerDAO extends JpaRepository<Customers, Long> {
    Customers findByUsername(String username);
}