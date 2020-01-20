package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public class Account<T> {
    private String nameOwner;
    private double balance;
    private PIN<T> pin;

    Account(String owner, double sum, PIN<T> pin) {
        this.nameOwner = owner;
        this.balance = sum;
        this.pin = pin;
    }

    void setPIN(PIN<T> pin) {
            this.pin = pin;
    }

    PIN<T> getPIN() {
        return this.pin;
    }

    void setBalance(double sum) {
        this.balance = sum;
    }

    double getBalance() {
        return this.balance;
    }

    void putBalance(double sum) {
        this.balance += sum;
    }

    boolean takeBalance(double sum) throws InsufficientFundsException {
        if (sum > this.balance) throw new InsufficientFundsException();
        this.balance -= sum;
        return true;
    }
}
