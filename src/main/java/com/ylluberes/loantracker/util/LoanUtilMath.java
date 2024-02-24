package com.ylluberes.loantracker.util;

import com.ylluberes.loantracker.domain.Loan;
import com.ylluberes.loantracker.domain.types.CompoundPerPeriod;
import com.ylluberes.loantracker.domain.types.InterestType;

public class LoanUtilMath {

    private static double getCompoundExpectedInterest (Loan loan) {
        double base = (1 + (loan.getInterestRate() / loan.getCapitalizationPeriod().getRepresentation()));
        return Math.pow(base, loan.getCapitalizationPeriod().getRepresentation() * loan.getLoanPeriodInYears());
    }

    private static double getLoanCompoundInterestExpectedBenefits (Loan loan) {
        return loan.getDisbursement() * getCompoundExpectedInterest(loan);
    }

    private static double getSimpleExpectedInterest (Loan loan) {
        return loan.getInterestRate() * loan.getLoanPeriodInYears();
    }

    private static double getLoanSimpleInterestExpectedBenefits (Loan loan) {
        return loan.getDisbursement() * getSimpleExpectedInterest(loan);
    }

    public static double getLoanExpectedBenefits (Loan loan) {
        if(InterestType.COMPOUND == loan.getInterestType()){
            return getLoanCompoundInterestExpectedBenefits(loan);
        }
        return getLoanSimpleInterestExpectedBenefits(loan);
    }


    public static void main(String[] args) {
        Loan loan = Loan.builder()
                .id("id")
                .concept("Test")
                .interestRate(0.1)
                .disbursement(5000)
                .loanPeriodInYears(5)
                .capitalizationPeriod(CompoundPerPeriod.WEEKLY)
                .interestType(InterestType.COMPOUND).build();
        double loanExpectedBenefits = getLoanExpectedBenefits(loan);
        System.out.println("Loan expected benefits: "+loanExpectedBenefits);
    }
}
