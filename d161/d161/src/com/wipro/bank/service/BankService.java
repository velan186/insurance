package com.wipro.bank.service;

import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;

public class BankService {

    public boolean validateData(float principal, int tenure, int age, String gender) throws BankValidationException {
        if (principal < 500) {
            throw new BankValidationException("Principal should be minimum 500");
        }
        if (!(tenure == 5 || tenure == 10)) {
            throw new BankValidationException("Tenure must be either 5 or 10");
        }
        if (!(gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female"))) {
            throw new BankValidationException("Gender must be Male or Female");
        }
        if (age < 1 || age > 100) {
            throw new BankValidationException("Age must be between 1 and 100");
        }
        return true;
    }

    public void calculate(float principal, int tenure, int age, String gender) {
        try {
            if (validateData(principal, tenure, age, gender)) {
                RDAccount rd = new RDAccount(tenure, principal);
                rd.setInterest(age, gender);

                float totalPrincipalDeposited = rd.calculateAmountDeposited();
                float maturityInterest = rd.calculateInterest();
                float maturityAmount = rd.calculateMaturityAmount(totalPrincipalDeposited, maturityInterest);

                System.out.println("Total Principal Deposited: " + totalPrincipalDeposited);
                System.out.println("Maturity Interest: " + maturityInterest);
                System.out.println("Maturity Amount: " + maturityAmount);
            }
        } catch (BankValidationException e) {
            System.out.println(e);
        }
    }
}
