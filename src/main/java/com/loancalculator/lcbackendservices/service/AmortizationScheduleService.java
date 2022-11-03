package com.loancalculator.lcbackendservices.service;

import com.loancalculator.lcbackendservices.model.AmortizationSchedule;
import com.loancalculator.lcbackendservices.model.Calculation;
import com.loancalculator.lcbackendservices.model.LoanRequest;
import com.loancalculator.lcbackendservices.repo.AmortizationScheduleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmortizationScheduleService {
    private final AmortizationScheduleRepo amortizationScheduleRepo;

    public AmortizationScheduleService(AmortizationScheduleRepo amortizationScheduleRepo) {
        this.amortizationScheduleRepo = amortizationScheduleRepo;
    }

    public void addAmortizationSchedule(AmortizationSchedule amortizationSchedule) {
        amortizationScheduleRepo.save(amortizationSchedule);
    }

    public List<AmortizationSchedule> findAllAmortizationSchedules() {
        return amortizationScheduleRepo.findAll();
    }



    public AmortizationSchedule updateAmortizationSchedule(AmortizationSchedule amortizationSchedule) {
        return amortizationScheduleRepo.save(amortizationSchedule);
    }

    public void deleteAmortizationSchedule(Long id) {
        amortizationScheduleRepo.deleteAmortizationScheduleById(id);
    }

    public List<AmortizationSchedule> findAmortizationScheduleById(Long id) {
        return amortizationScheduleRepo.findAllByCalculationId(id);
    }


    public void handleAmortizationSchedule(LoanRequest loanRequest, Calculation calculation) {
        int months = loanRequest.getLoanTerm();
        double debt = loanRequest.getLoanAmount();
        double interestRatePerMonth = loanRequest.getInterestRate() / 100 / 12;

        for (int i = 1; i <= months; i++) {
            AmortizationSchedule amortizationSchedule = new AmortizationSchedule();

            amortizationSchedule.setMonth(i);
            amortizationSchedule.setPaymentAmount(calculation.getMonthlyPayment());
            amortizationSchedule.setInterestAmount(calculateInterestAmount(debt, interestRatePerMonth));
            amortizationSchedule.setPrincipalAmount(
                    calculatePrincipalAmount(
                            amortizationSchedule.getPaymentAmount(),
                            amortizationSchedule.getInterestAmount()
                    )
            );
            debt = Math.round((debt - amortizationSchedule.getPrincipalAmount()) * 100.0) / 100.0;
            amortizationSchedule.setBalanceOwned(debt);
            amortizationSchedule.setCalculationId(calculation.getId());
            //save amortization schedule to the db
            addAmortizationSchedule(amortizationSchedule);
        }
    }

    public double calculateInterestAmount(double debt, double interestRatePerMonth) {
        return Math.round(debt * interestRatePerMonth * 100.0) / 100.0;
    }

    public double calculatePrincipalAmount(double paymentAmount, double interestAmount) {
        return Math.round((paymentAmount - interestAmount) * 100.0) / 100.0;
    }
}
