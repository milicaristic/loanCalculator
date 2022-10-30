package com.loancalculator.lcbackendservices.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AmortizationSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private int month;
    private double paymentAmount;
    private double principalAmount;
    private double interestAmount;
    private double balanceOwned;
    private Long calculationId;

    public AmortizationSchedule() {
    }

    public AmortizationSchedule(Long id, int month, double paymentAmount, double principalAmount,
                                double interestAmount, double balanceOwned, Long calculationId) {
        this.id = id;
        this.month = month;
        this.paymentAmount = paymentAmount;
        this.principalAmount = principalAmount;
        this.interestAmount = interestAmount;
        this.balanceOwned = balanceOwned;
        this.calculationId = calculationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(double principalAmount) {
        this.principalAmount = principalAmount;
    }

    public double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(double interestAmount) {
        this.interestAmount = interestAmount;
    }

    public double getBalanceOwned() {
        return balanceOwned;
    }

    public void setBalanceOwned(double balanceOwned) {
        this.balanceOwned = balanceOwned;
    }

    public Long getCalculationId() {
        return calculationId;
    }

    public void setCalculationId(Long calculationId) {
        this.calculationId = calculationId;
    }

    @Override
    public String toString() {
        return "AmortizationSchedule{" +
                "amortizationSchemaId=" + id +
                ", month=" + month +
                ", paymentAmount=" + paymentAmount +
                ", principalAmount=" + principalAmount +
                ", interestAmount=" + interestAmount +
                ", balanceOwned=" + balanceOwned +
                '}';
    }
}
