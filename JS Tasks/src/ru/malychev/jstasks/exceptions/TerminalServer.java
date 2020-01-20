package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.InsufficientFundsException;

public class TerminalServer<T> {

    private ClientDB<T> clients;

    TerminalServer(ClientDB<T> clients) {
        this.clients = clients;
    }

    PIN<T> getPINClient(int account) throws AccountNotFoundException {
        return clients.getPINClient(account);
    }

    void allowMoney(int sum, int account) throws InsufficientFundsException {
        clients.getAccountClient(account).takeBalance(sum);
    }

    void putMoney(int sum, int account) {
        clients.getAccountClient(account).putBalance(sum);
    }

}
