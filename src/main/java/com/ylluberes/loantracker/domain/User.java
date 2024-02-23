package com.ylluberes.loantracker.domain;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String name;
    private String lastname;
    private String email;
    private String phoneNumber;

}
