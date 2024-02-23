package com.ylluberes.loantracker.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Borrower extends User {

    private String id;
    private double totalScore;


}
