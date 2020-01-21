package ru.malychev.jstasks.exceptions.bankexceptions;

public class AccountNotFoundException extends Exception {
    public AccountNotFoundException() {
        super("\nДанный счет не может быть обслужен бакоматом!");
    }
}
