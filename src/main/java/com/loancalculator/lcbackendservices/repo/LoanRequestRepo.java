package com.loancalculator.lcbackendservices.repo;

import com.loancalculator.lcbackendservices.model.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface LoanRequestRepo extends JpaRepository<LoanRequest, Long> {
    @Transactional
    void deleteLoanRequestById(Long id);

    LoanRequest findLoanRequestById(Long id);
}
