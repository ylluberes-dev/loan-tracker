package com.ylluberes.loantracker.controllers;

import com.ylluberes.loantracker.domain.Loan;
import com.ylluberes.loantracker.domain.types.LoanStatus;
import com.ylluberes.loantracker.dto.NewLoanRequestDto;
import com.ylluberes.loantracker.exceptions.LoanNotFoundException;
import com.ylluberes.loantracker.repository.LoanRepository;
import com.ylluberes.loantracker.services.LoanService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/loans")
public class LoanController {


    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/{loanId}")
    public ResponseEntity<Loan> findLoan (@PathVariable ("loanId") String loanId) throws LoanNotFoundException {
        return new ResponseEntity<>(loanService.findLoanById(loanId),HttpStatus.OK);
    }
}
