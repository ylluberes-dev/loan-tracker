package com.ylluberes.loantracker.services;


import com.ylluberes.loantracker.domain.Loan;
import com.ylluberes.loantracker.exceptions.LoanNotFoundException;
import com.ylluberes.loantracker.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService  (LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan findLoanById (String loanId) throws LoanNotFoundException {
        return loanRepository.findById(loanId).orElseThrow(() -> new LoanNotFoundException("Loan with id "+loanId +" was not found"));
    }


}
