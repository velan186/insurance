package com.wipro.bank.acc;

public class RDAccount extends Account {

    public RDAccount(int tenure, float principal) {
        this.tenure = tenure;
        this.principal = principal;
    }

    @Override
    public float calculateAmountDeposited() {
        return principal * tenure * 12; // monthly deposit × tenure × months
    }

    @Override
    public float calculateInterest() {
        int n = 12; // compounding monthly
        float r = rateOfInterest / 100; // convert % to decimal
        float t = tenure; // tenure in years
        // Formula: P * (((1 + r/n)^(n*t)) - 1)
        return (float) (principal * (Math.pow(1 + r / n, n * t) - 1));
    }
}
