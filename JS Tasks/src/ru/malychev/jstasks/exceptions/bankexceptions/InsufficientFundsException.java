package ru.malychev.jstasks.exceptions.bankexceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(){
        System.out.println("\nНа счете недостаточно средств!");
    }
}
