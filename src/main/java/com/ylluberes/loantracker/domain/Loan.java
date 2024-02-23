package com.ylluberes.loantracker.domain;

import com.ylluberes.loantracker.domain.types.CompoundPerPeriod;
import com.ylluberes.loantracker.domain.types.LoanStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collation = "loan")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Loan {

    @Id
    private String id;
    private String concept;
    private LoanStatus loanStatus;
    private LocalDateTime createdDate;
    private Lender lender;
    private Borrower borrower;
    private double disbursement;
    private double interestRate;
    private double currentBalance;
    private CompoundPerPeriod capitalizationPeriod;
    int loanPeriodInYears;
    private LocalDateTime dueDate;
    private List<Payments> payments;

    public double getCompoundInterestExpectedAmount () {
        double base = (1 + (interestRate / capitalizationPeriod.getRepresentation()));
        double ex =  Math.pow(base,CompoundPerPeriod.MONTHLY.getRepresentation() * loanPeriodInYears);
        return disbursement * ex;
    }

    public double getLenderLoanBenefits () {
        return getCompoundInterestExpectedAmount() - disbursement;
    }

    //TODO Create a function to get the getSimpleInterestExpectedAmount
}
