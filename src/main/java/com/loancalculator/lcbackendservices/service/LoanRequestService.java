package com.loancalculator.lcbackendservices.service;

import com.loancalculator.lcbackendservices.model.Calculation;
import com.loancalculator.lcbackendservices.model.LoanRequest;
import com.loancalculator.lcbackendservices.repo.LoanRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanRequestService {
    private final LoanRequestRepo loanRequestRepo;
    private final CalculationService calculationService;

    private final AmortizationScheduleService amortizationScheduleService;

    @Autowired
    public LoanRequestService(LoanRequestRepo loanRequestRepo, CalculationService calculationService,
                              AmortizationScheduleService amortizationScheduleService) {
        this.loanRequestRepo = loanRequestRepo;
        this.calculationService = calculationService;
        this.amortizationScheduleService = amortizationScheduleService;
    }

    public LoanRequest addLoanRequest(LoanRequest loanRequest) {
        Calculation calculation = calculationService.handleCalculation(loanRequest);
        loanRequest.setId(calculation.getId());
        amortizationScheduleService.handleAmortizationSchedule(loanRequest, calculation);
        return loanRequestRepo.save(loanRequest);
    }

    public List<LoanRequest> findAllLoanRequests() {
        return loanRequestRepo.findAll();
    }

    public LoanRequest updateLoanRequest(LoanRequest loanRequest) {
        return loanRequestRepo.save(loanRequest);
    }

    public void deleteLoanRequest(Long id) {
        loanRequestRepo.deleteLoanRequestById(id);
    }

    public LoanRequest findLoanRequestById(Long id) {
        return loanRequestRepo.findLoanRequestById(id);
    }
}
