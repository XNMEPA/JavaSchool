package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectAmountException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;
import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public interface Terminal<T> {
    boolean checkClient(int account, PIN<T> pin) throws AccountNotFoundException, IncorrectPINException;
    void takeMoney(int sum, int account) throws InsufficientFundsException, IncorrectAmountException;
    void putMoney(int sum, int account) throws IncorrectAmountException;
}
