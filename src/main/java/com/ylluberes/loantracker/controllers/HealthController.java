package com.ylluberes.loantracker.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/health")
@RestController
public class HealthController {

    @GetMapping
    public String checkHealth () {
        return "Server is alive";
    }
}
