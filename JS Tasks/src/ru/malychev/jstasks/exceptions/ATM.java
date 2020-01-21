package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.*;

import java.util.Date;

public class ATM<T> implements Terminal<T> {

    private PINValidator<T> validator;
    private TerminalServer<T> server;

    public ATM (PINValidator<T> validator, TerminalServer<T> server) {
        this.validator = validator;
        this.server = server;
    }

    public void checkClient(int account, PIN<T> pin) {
        try {
            Date currentTime = new Date();
            validator.checkPIN(account, pin, server);
            try {
                if (validator.getEndTimeLock().after(currentTime))
                    throw new AccountIsLockedException((validator.getEndTimeLock().getTime() - currentTime.getTime()) / 1000);
            } catch (AccountIsLockedException e) {
                System.out.println("\n=================================================================");
                System.out.println(e);
                System.out.println("=================================================================");
            }
        } catch (AccountNotFoundException e) {
            System.out.println(e);
            System.out.println("\n=================================================================");
            System.out.println("Возможно счет введен с ошибкой.\nВвод счета можно повторить.");
            System.out.println("=================================================================");
        } catch (IncorrectPINException e) {
            System.out.println(e);
            System.out.println("\n=================================================================");
            System.out.println("Введен некорректный PIN-код.");
            System.out.println("=================================================================");
        }
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
