package ru.malychev.jstasks.exceptions.bankexceptions;

public class IncorrectPINException extends Exception {

    public IncorrectPINException(int attempts) {
        super("\nВведен некорректный PIN.\nОсталось " + (attempts == 2 ? "две попытки." : "одна попытка."));
    }
}
