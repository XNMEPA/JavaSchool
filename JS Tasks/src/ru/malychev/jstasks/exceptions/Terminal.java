package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.*;

public interface Terminal<T> {
    boolean checkClient(int account, PIN<T> pin) throws AccountIsLockedException;
    void takeMoney(int sum, int account) throws InsufficientFundsException, IncorrectAmountException;
    void putMoney(int sum, int account) throws IncorrectAmountException;
}
