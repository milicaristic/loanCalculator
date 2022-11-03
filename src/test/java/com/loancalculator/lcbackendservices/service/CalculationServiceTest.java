package com.loancalculator.lcbackendservices.service;

import com.loancalculator.lcbackendservices.repo.CalculationRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculationServiceTest {

    CalculationService calculationService = null;
    CalculationRepo calculationRepo = Mockito.mock(CalculationRepo.class);

    @BeforeTestClass
    public void setUp() {
        calculationService = new CalculationService(calculationRepo);
    }

    @Test
    void calculateMonthlyPayment() {
        calculationService = new CalculationService(calculationRepo);
        assertEquals(377.4283380431447, calculationService.calculateMonthlyPayment(20000, 0.004167, 60));
    }

    @Test
    void calculateTotalInterestPaid() {
        calculationService = new CalculationService(calculationRepo);
        assertEquals(2645.7999999999993, calculationService.calculateTotalInterestPaid(
                377.43, 60, 20000.0)
        );
    }
}