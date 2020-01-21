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

    public boolean checkClient(int account, PIN<T> pin) {
        try {
            Date currentTime = new Date();
            if (validator.getEndTimeLock().after(currentTime))
                throw new AccountIsLockedException((validator.getEndTimeLock().getTime() - currentTime.getTime()) / 1000);
            else if (validator.checkPIN(account, pin, server)) {
                System.out.println("Клиент авторизован.");
                return true;
            }
        } catch (AccountNotFoundException e) {
            System.out.println("Возможно счет введен с ошибкой.\nВвод счета можно повторить.");
            System.out.println("=================================================================");
        } catch (IncorrectPINException e) {
            System.out.println("Повторите ввод авторизационных данных.");
            System.out.println("=================================================================");
        } catch (AccountIsLockedException e) {
            System.out.println("=================================================================");
        }
        return false;
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
