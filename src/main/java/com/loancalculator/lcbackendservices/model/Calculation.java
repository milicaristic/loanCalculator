package com.loancalculator.lcbackendservices.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Calculation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private double monthlyPayment;
    private double totalInterestPaid;

    public Calculation() {
    }

    public Calculation(Long id, double monthlyPayment, double totalInterestPaid, Long amortizationScheduleId) {
        this.id = id;
        this.monthlyPayment = monthlyPayment;
        this.totalInterestPaid = totalInterestPaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public void setTotalInterestPaid(double totalInterestPaid) {
        this.totalInterestPaid = totalInterestPaid;
    }
}
