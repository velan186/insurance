package com.wipro.bank.exception;

public class BankValidationException extends Exception {
    public BankValidationException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Invalid data: " + getMessage();
    }
}
