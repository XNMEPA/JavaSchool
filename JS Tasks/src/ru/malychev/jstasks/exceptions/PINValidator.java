package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

public abstract class PINValidator<T> {
    abstract boolean checkPIN(int account, PIN<T> pin, TerminalServer<T> server) throws AccountNotFoundException, IncorrectPINException;
}
