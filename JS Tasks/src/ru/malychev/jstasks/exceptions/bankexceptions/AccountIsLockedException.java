package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountIsLockedException extends Exception {

    public AccountIsLockedException(int seconds) {
        super("Счет заблокирован.\nРазблокировка произойдет через " + seconds + "сек.");
    }
}
