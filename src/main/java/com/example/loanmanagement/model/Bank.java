package com.example.loanmanagement.model;

import jakarta.persistence.*;


@Entity
@Table(name = "banks")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String ifscCode;
    private String city;
    private String address;
    private String contactNumber;
    private String email;
    private String bankName;

    public Bank(){
        
    }

    public Bank(Long id, String ifscCode, String city, String address, String contactNumber, String email,
            String bankName) {
        this.id = id;
        this.ifscCode = ifscCode;
        this.city = city;
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.bankName = bankName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }  
}

