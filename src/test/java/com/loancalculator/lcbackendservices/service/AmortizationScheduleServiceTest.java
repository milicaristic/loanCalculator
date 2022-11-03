package com.loancalculator.lcbackendservices.service;

import com.loancalculator.lcbackendservices.repo.AmortizationScheduleRepo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;


class AmortizationScheduleServiceTest {
    AmortizationScheduleService amortizationScheduleService = null;
    AmortizationScheduleRepo amortizationScheduleRepo = Mockito.mock(AmortizationScheduleRepo.class);

    @Test
    void calculateInterestAmount() {
        amortizationScheduleService = new AmortizationScheduleService(amortizationScheduleRepo);
        assertEquals(83.34, amortizationScheduleService.calculateInterestAmount(20000.0,0.004167 ));
    }

    @Test
    void calculatePrincipalAmount() {
        amortizationScheduleService = new AmortizationScheduleService(amortizationScheduleRepo);
        assertEquals(294.09, amortizationScheduleService.calculatePrincipalAmount(377.42,83.33));
    }
}