package ru.malychev.jstasks.exceptions.bankexceptions;

public class IncorrectAmountException extends Exception {

    public IncorrectAmountException(){
        System.out.println("\nСумма должна быть кратна 100 рублям.");
    }
}
