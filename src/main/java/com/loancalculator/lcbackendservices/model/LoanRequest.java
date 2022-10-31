package com.loancalculator.lcbackendservices.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class LoanRequest implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    private Long id;
    private double loanAmount;
    private double interestRate;
    private int loanTerm;

    public LoanRequest() {
    }

    public LoanRequest(Long id, double loanAmount, double interestRate, int loanTerm) {
        this.id = id;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanTerm = loanTerm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }
}
