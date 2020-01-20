package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public class Account<T> {
    private String nameOwner;
    private double account;
    private PIN<T> pin;

    public Account(String owner, double sum, PIN<T> pin) {
        this.nameOwner = owner;
        this.account = sum;
        this.pin = pin;
    }

    public void setPIN(PIN<T> pin) {
            this.pin = pin;
    }

    public PIN<T> getPIN() {
        return this.pin;
    }

    public void setAccount(double sum) {
        this.account = sum;
    }

    public double getAccount() {
        return this.account;
    }

    public void putAccount(double sum) {
        this.account += sum;
    }

    public double takeAccount(double sum) throws InsufficientFundsException {
        if (sum > this.account) throw new InsufficientFundsException();
        return (this.account -= sum);
    }
}
