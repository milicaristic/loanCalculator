package com.loancalculator.lcbackendservices.controller;

import com.loancalculator.lcbackendservices.model.LoanRequest;
import com.loancalculator.lcbackendservices.service.CalculationService;
import com.loancalculator.lcbackendservices.service.LoanRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loanRequest")
public class LoanRequestController {
    private final LoanRequestService loanRequestService;
    private final CalculationService calculationService;

    public LoanRequestController(LoanRequestService loanRequestService, CalculationService calculationService) {
        this.loanRequestService = loanRequestService;
        this.calculationService = calculationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LoanRequest>> getAllLoanRequests(){
        List<LoanRequest> loanRequests = loanRequestService.findAllLoanRequests();
        return new ResponseEntity<>(loanRequests, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<LoanRequest> getLoanRequestById(@PathVariable("id") Long id) {
        LoanRequest loanRequest = loanRequestService.findLoanRequestById(id);
        return new ResponseEntity<>(loanRequest, HttpStatus.OK);
    }

    public ResponseEntity<LoanRequest> addLoanRequest(LoanRequest loanRequest){
        LoanRequest newLoanRequest = loanRequestService.addLoanRequest(loanRequest);
        return new ResponseEntity<>(newLoanRequest, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<LoanRequest> updateLoanRequest(@RequestBody LoanRequest loanRequest){
        LoanRequest updatedLoanRequest = loanRequestService.updateLoanRequest(loanRequest);
        return new ResponseEntity<>(updatedLoanRequest, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLoanRequest(@PathVariable("id") Long id){
        loanRequestService.deleteLoanRequest(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
