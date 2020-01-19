package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

public class Account {
    private final String nameOwner;
    private double account;
    private int pin;

    public Account(String owner, double sum, int pin) {
        this.nameOwner = owner;
        this.account = sum;
        this.pin = pin;
    }

//    public boolean checkPIN
    public void setPIN(int oldPIN, int newPIN) throws IncorrectPINException {
        if (oldPIN == this.pin) {
            this.pin = newPIN;
        }
        throw new IncorrectPINException(3);
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
    public double takeAccount(double sum) {
        return (this.account -= sum);
    }
}
