package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectAmountException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

public interface Terminal {
    double checkAccount( Account account, int pin);
    double takeMoney(double sum, Account account);
    void putMoney(double sum, Account account) throws IncorrectAmountException;
}
