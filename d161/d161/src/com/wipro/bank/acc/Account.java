package com.wipro.bank.acc;

public abstract class Account {
    protected int tenure;       // in years
    protected float principal;  // monthly deposit
    protected float rateOfInterest;

    public void setInterest(int age, String gender) {
        if (gender.equalsIgnoreCase("Male") && age < 60) {
            this.rateOfInterest = 9.81f;
        } else if (gender.equalsIgnoreCase("Male") && age >= 60) {
            this.rateOfInterest = 10.5f;
        } else if (gender.equalsIgnoreCase("Female") && age < 58) {
            this.rateOfInterest = 10.2f;
        } else if (gender.equalsIgnoreCase("Female") && age >= 58) {
            this.rateOfInterest = 10.8f;
        }
    }

    public float calculateMaturityAmount(float totalPrincipalDeposited, float maturityInterest) {
        return totalPrincipalDeposited + maturityInterest;
    }

    public abstract float calculateInterest();
    public abstract float calculateAmountDeposited();
}
