package com.loancalculator.lcbackendservices.repo;

import com.loancalculator.lcbackendservices.model.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface CalculationRepo extends JpaRepository<Calculation, Long> {
    @Transactional
    void deleteCalculationById(Long id);

    Calculation findCalculationById(Long id);
}
