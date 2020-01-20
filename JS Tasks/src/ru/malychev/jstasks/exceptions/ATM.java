package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectAmountException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;
import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public class ATM<T> implements Terminal<T> {

    private PINValidator<T> validator;
    private TerminalServer<T> server;

    public ATM (PINValidator<T> validator, TerminalServer<T> server) {
        this.validator = validator;
        this.server = server;
    }

    public boolean checkClient(int account, PIN<T> pin) throws AccountNotFoundException, IncorrectPINException {
        return validator.checkPIN(account, pin, server);
    }

    public void takeMoney(int sum, int account) throws InsufficientFundsException, IncorrectAmountException {
        if (sum % 100 != 0) throw new IncorrectAmountException();
        server.allowMoney(sum, account);
    }

    public void putMoney(int sum, int account) throws IncorrectAmountException{
        if (sum % 100 != 0) throw new IncorrectAmountException();
        server.putMoney(sum, account);
    }

}
