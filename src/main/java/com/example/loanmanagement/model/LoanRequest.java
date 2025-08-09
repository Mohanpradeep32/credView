package com.example.loanmanagement.model;

public class LoanRequest {
    private String loanType;
    private double loanAmount;
    private double interestRate; 
    private int tenure; 
    private int repayDay;

    public LoanRequest(){
        
    }

   
    public LoanRequest(String loanType, double loanAmount, double interestRate, int tenure, int repayDay) {
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.tenure = tenure;
        this.repayDay = repayDay;
    }
    public String getLoanType() {
        return loanType;
    }
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public int getTenure() {
        return tenure;
    }
    public void setTenure(int tenure) {
        this.tenure = tenure;
    }
    public int getRepayDay() {
        return repayDay;
    }
    public void setRepayDay(int repayDay) {
        this.repayDay = repayDay;
    }
}

