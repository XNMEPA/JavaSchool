package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountIsLockedException extends Exception {

    public AccountIsLockedException(long seconds) {
        System.out.println("\n=================================================================");
        System.out.println("Счет заблокирован.\nРазблокировка произойдет через " + seconds + " сек.");
    }
}
