package ru.malychev.jstasks.exceptions.bankexceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        super("\nНа счете недостаточно средств!");
    }
}
