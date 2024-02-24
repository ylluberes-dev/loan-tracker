package com.ylluberes.loantracker.domain.types;

import lombok.Getter;

@Getter
public enum CompoundPerPeriod {

    DAILY(365),
    WEEKLY(52),
    BIWEEKLY(25),
    MONTHLY(12),
    BIMONTHLY(6),
    QUARTERLY(3),
    SEMIANNUAL(2),
    ANNUAL(1);

    private final int representation;

    CompoundPerPeriod(int representation) {
        this.representation = representation;
    }
}
