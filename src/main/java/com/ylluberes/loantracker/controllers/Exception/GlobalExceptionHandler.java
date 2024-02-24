package com.ylluberes.loantracker.controllers.Exception;


import com.ylluberes.loantracker.exceptions.LoanNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({LoanNotFoundException.class})
    public ResponseEntity<Object> handleLoanNotFoundException (LoanNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exception.getMessage());
    }

}
