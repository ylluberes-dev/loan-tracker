package com.ylluberes.loantracker.controllers;

import com.ylluberes.loantracker.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController
public class HealthController {



    private final LoanRepository loanRepository;

    @Autowired
    public HealthController(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    @GetMapping
    public String checkHealth () {
        return "Server is alive";
    }
}
