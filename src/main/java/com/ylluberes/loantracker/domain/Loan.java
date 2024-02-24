package com.ylluberes.loantracker.domain;

import com.ylluberes.loantracker.domain.types.CompoundPerPeriod;
import com.ylluberes.loantracker.domain.types.InterestType;
import com.ylluberes.loantracker.domain.types.LoanStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "loan")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder(toBuilder = true)
public class Loan {

    @Id
    private String id;
    private String concept;
    private LoanStatus loanStatus;
    private LocalDateTime createdDate;
    private Lender lender;
    private Borrower borrower;
    private double disbursement;
    private InterestType interestType;
    private double interestRate;
    private double currentBalance;
    private CompoundPerPeriod capitalizationPeriod;
    int loanPeriodInYears;
    private LocalDateTime dueDate;
    private List<Payments> payments;

}
