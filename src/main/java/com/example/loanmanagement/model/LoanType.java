package com.example.loanmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "loan_types")
public class LoanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loanTypeName;
    private double interestRate;
    private double maxLoanAmount;
    private int tenureMonths;
    private int repaymentDay;

    private String description; 

    public LoanType() {
    }

    public LoanType(String loanTypeName, double interestRate, double maxLoanAmount, int tenureMonths, int repaymentDay, String description) {
        this.loanTypeName = loanTypeName;
        this.interestRate = interestRate;
        this.maxLoanAmount = maxLoanAmount;
        this.tenureMonths = tenureMonths;
        this.repaymentDay = repaymentDay;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoanTypeName() {
        return loanTypeName;
    }

    public void setLoanTypeName(String loanTypeName) {
        this.loanTypeName = loanTypeName;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMaxLoanAmount() {
        return maxLoanAmount;
    }

    public void setMaxLoanAmount(double maxLoanAmount) {
        this.maxLoanAmount = maxLoanAmount;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public void setTenureMonths(int tenureMonths) {
        this.tenureMonths = tenureMonths;
    }

    public int getRepaymentDay() {
        return repaymentDay;
    }

    public void setRepaymentDay(int repaymentDay) {
        this.repaymentDay = repaymentDay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
