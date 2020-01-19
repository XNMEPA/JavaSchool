package ru.malychev.jstasks.exceptions.bankexceptions;

public class IncorrectAmountException extends Exception {

    public IncorrectAmountException(){
        super("Сумма должна быть кратна 100 рублям.");
    }
}
