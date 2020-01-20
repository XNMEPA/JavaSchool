package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ClientDB<T> {
    private Map<Integer, Account<T>> clients;

    ClientDB() {
        this.clients = new HashMap<>();
    }

    void addClient(int account, String owner, double sum, PIN<T> pin) {
        clients.put(account, new Account<>(owner, sum, pin));
    }

    void removeClient(int account) {
        clients.remove(account);
    }

    PIN<T> getPINClient(int account) throws AccountNotFoundException {
        if (clients.containsKey(account))
            return clients.get(account).getPIN();
        else throw new AccountNotFoundException();
    }

    Account<T> getAccountClient(int account) {
        return clients.get(account);
    }
}
