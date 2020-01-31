package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException() {
        System.out.println("=================================================================");
        System.out.println("Данный счет не может быть обслужен бакоматом!");
        System.out.println("=================================================================");
    }
}
