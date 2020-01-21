package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountIsLockedException extends Exception {

    public AccountIsLockedException(long seconds) {
        super("\nСчет заблокирован.\nРазблокировка произойдет через " + seconds + " сек.");
    }
}
