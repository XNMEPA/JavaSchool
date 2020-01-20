package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectAmountException;
import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public interface Terminal {
    double checkAccount( Account account, int pin) throws AccountNotFoundException;
    double takeMoney(double sum, Account account) throws InsufficientFundsException;
    void putMoney(double sum, Account account) throws IncorrectAmountException;
}
