package ru.malychev.jstasks.exceptions.bankexceptions;

public class ServerTimeOutException extends Exception {
    public ServerTimeOutException() {
        super("\nСервер недоступен.");
    }
}
