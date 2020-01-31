package ru.malychev.jstasks.exceptions.bankexceptions;

public class IncorrectPINException extends Exception {

    public IncorrectPINException(int attempts) {
        System.out.println("=================================================================");
        System.out.println("Введен некорректный PIN.");
        System.out.println((attempts == 1 ? "Осталась одна попытка." : "Осталось две попытки."));
        System.out.println("=================================================================");
    }
}
