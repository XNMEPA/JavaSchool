package ru.malychev.jstasks.exceptions;

public interface PinValidator<T> {
    boolean checkPIN(PIN<T> pin, Account account);
}
