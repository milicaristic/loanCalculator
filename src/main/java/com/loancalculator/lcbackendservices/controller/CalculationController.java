package com.loancalculator.lcbackendservices.controller;

import com.loancalculator.lcbackendservices.model.Calculation;
import com.loancalculator.lcbackendservices.service.CalculationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculation")
public class CalculationController {
    private final CalculationService calculationService;

    public CalculationController(CalculationService calculationService) {
        this.calculationService = calculationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Calculation>> getAllCalculations() {
        List<Calculation> calculations = calculationService.findAllCalculations();
        return new ResponseEntity<>(calculations, HttpStatus.OK);
    }

    public ResponseEntity<Calculation> getCalculationById(Long id) {
        Calculation calculation = calculationService.findCalculationById(id);
        return new ResponseEntity<>(calculation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCalculation(@PathVariable("id") Long id) {
        calculationService.deleteCalculation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
