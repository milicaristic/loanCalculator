package com.loancalculator.lcbackendservices.repo;

import com.loancalculator.lcbackendservices.model.AmortizationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface AmortizationScheduleRepo extends JpaRepository<AmortizationSchedule, Long> {
    @Transactional
    void deleteAmortizationScheduleById(Long id);

    List<AmortizationSchedule> findAllByCalculationId(Long id);
}
