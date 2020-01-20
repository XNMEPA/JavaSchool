package ru.malychev.jstasks.exceptions;

public class Main {
    public static void main(String[] args) {

        ClientDB<Integer> sberClients = new ClientDB<>();
        sberClients.addClient(1, "Степа", 10000D, new NumberPIN(1234));
        
    }

}
