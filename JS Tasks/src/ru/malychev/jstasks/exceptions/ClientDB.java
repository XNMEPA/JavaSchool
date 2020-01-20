package ru.malychev.jstasks.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ClientDB<T> {
    private Map<Integer, Account<T>> clients;

    ClientDB() {
        this.clients = new HashMap<>();
    }

    public void addClient(int account, String owner, double sum, PIN<T> pin) {
        clients.put(account, new Account<>(owner, sum, pin));
    }
}
