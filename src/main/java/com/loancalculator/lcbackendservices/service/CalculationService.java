package com.loancalculator.lcbackendservices.service;

import com.loancalculator.lcbackendservices.model.Calculation;
import com.loancalculator.lcbackendservices.model.LoanRequest;
import com.loancalculator.lcbackendservices.repo.CalculationRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationService {
    private final CalculationRepo calculationRepo;

    public CalculationService(CalculationRepo calculationRepo) {
        this.calculationRepo = calculationRepo;
    }

    public Calculation handleCalculation(LoanRequest loanRequest) {
        Calculation calculation = new Calculation();
        double loanAmount = loanRequest.getLoanAmount();
        double interestRate = loanRequest.getInterestRate() / 100 / 12;
        int months = loanRequest.getLoanTerm();

        double monthlyPayment = calculateMonthlyPayment(loanAmount, interestRate, months);
        double totalInterestPaid = calculateTotalInterestPaid(monthlyPayment, months, loanAmount);

        calculation.setMonthlyPayment((Math.round(monthlyPayment * 100.0)) / 100.0);
        calculation.setTotalInterestPaid((Math.round(totalInterestPaid * 100.0)) / 100.0);

        return addCalculation(calculation);
    }

    public double calculateMonthlyPayment(double loanAmount, double interestRate, int months) {
        return (loanAmount * interestRate * Math.pow((1 + interestRate), months)) / (Math.pow((1 + interestRate), months) - 1);
    }

    public double calculateTotalInterestPaid(double monthlyPayment, int months, double loanAmount) {
        return (monthlyPayment * months) - loanAmount;
    }

    private Calculation addCalculation(Calculation calculation) {
        return calculationRepo.save(calculation);
    }

    public List<Calculation> findAllCalculations() {
        return calculationRepo.findAll();
    }

    public void deleteCalculation(Long id) {
        calculationRepo.deleteCalculationById(id);
    }

    public Calculation findCalculationById(Long id) {
        return calculationRepo.findCalculationById(id);
    }
}
