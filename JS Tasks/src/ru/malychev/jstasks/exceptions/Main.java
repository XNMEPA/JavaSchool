package ru.malychev.jstasks.exceptions;

public class Main {
    public static void main(String[] args) {

        ClientDB<Integer> sberClients = new ClientDB<>();
        sberClients.addClient(1, "Степа", 10000D, new NumberPIN(1234));
        sberClients.addClient(2, "Вася", 1000D, new NumberPIN(3434));
        sberClients.addClient(3, "Лена", 100000D, new NumberPIN(4321));

    }

}
