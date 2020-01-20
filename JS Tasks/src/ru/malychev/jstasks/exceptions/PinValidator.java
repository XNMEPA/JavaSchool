package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

public interface PinValidator<T> {
    boolean checkPIN(PIN<T> pin, Account account) throws AccountNotFoundException, IncorrectPINException;
}
