package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException() {
        super("Данная карта не может быть обслудена бакоматом!");
    }
}
