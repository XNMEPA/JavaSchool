package ru.malychev.jstasks.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TerminalServer {

    private Map<Integer, Integer> accounts;
    private List<Account<Integer>> clients;

    TerminalServer() {
        this.accounts = new HashMap<>();
        this.clients = new ArrayList<>();
    }

}
