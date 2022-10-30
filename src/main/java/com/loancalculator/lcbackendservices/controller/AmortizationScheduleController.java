package com.loancalculator.lcbackendservices.controller;

import com.loancalculator.lcbackendservices.model.AmortizationSchedule;
import com.loancalculator.lcbackendservices.model.LoanRequest;
import com.loancalculator.lcbackendservices.service.AmortizationScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amortizationSchedule")
public class AmortizationScheduleController {

    private final AmortizationScheduleService amortizationScheduleService;


    public AmortizationScheduleController(AmortizationScheduleService amortizationScheduleService) {
        this.amortizationScheduleService = amortizationScheduleService;
    }

    public ResponseEntity<List<AmortizationSchedule>> getAmortizationScheduleById(Long id) {
        List<AmortizationSchedule> amortizationSchedule = amortizationScheduleService.findAmortizationScheduleById(id);
        return new ResponseEntity<>(amortizationSchedule, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AmortizationSchedule>> getAllAmortizationSchedules(){
        List<AmortizationSchedule> allAmortizationSchedules = amortizationScheduleService.findAllAmortizationSchedules();
        return new ResponseEntity<>(allAmortizationSchedules, HttpStatus.OK);
    }
}
