package com.ylluberes.loantracker.domain;


import lombok.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Payments {

    private String id;
    private String paymentNote;
    private double amount;
    private double nextPaymentAmount;
    private LocalDateTime paymentDate;
    private LocalDateTime nextPaymentDate;




}
