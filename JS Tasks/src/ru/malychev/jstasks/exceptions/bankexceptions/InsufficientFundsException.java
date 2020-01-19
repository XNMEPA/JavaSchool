package ru.malychev.jstasks.exceptions.bankexceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        super("На счете недостаточно средств!");
    }
}
