package com.loancalculator.lcbackendservices.controller;

import com.loancalculator.lcbackendservices.model.AmortizationSchedule;
import com.loancalculator.lcbackendservices.model.Calculation;
import com.loancalculator.lcbackendservices.model.LoanRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainController {
    private final LoanRequestController loanRequestController;
    private final CalculationController calculationController;
    private final AmortizationScheduleController amortizationScheduleController;

    public MainController(LoanRequestController loanRequestController, CalculationController calculationController,
                          AmortizationScheduleController amortizationScheduleController) {
        this.loanRequestController = loanRequestController;
        this.calculationController = calculationController;
        this.amortizationScheduleController = amortizationScheduleController;
    }


    @PostMapping("/add")
    public ResponseEntity<LoanRequest> addLoanRequest(@RequestBody LoanRequest loanRequest){
        return loanRequestController.addLoanRequest(loanRequest);
    }

    @GetMapping("/find")
    public ResponseEntity<Calculation> getCalculationByLoanRequestId(@RequestBody LoanRequest loanRequest) {
        return calculationController.getCalculationById(loanRequest.getId());
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<AmortizationSchedule>> getAmortizationSchedule() {
        return amortizationScheduleController.getAllAmortizationSchedules();
    }

    @GetMapping("/findAmortizationSchedule")
    public ResponseEntity<List<AmortizationSchedule>> getAmortizationScheduleByCalculation(@RequestBody Calculation calculation) {
        return amortizationScheduleController.getAmortizationScheduleById(calculation.getId());
    }
}