package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountIsLockedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ClientDB<Integer> sberClients = new ClientDB<>();
        sberClients.addClient(1, "Степа", 10000D, new NumberPIN(1234));
        sberClients.addClient(2, "Вася", 1000D, new NumberPIN(3434));
        sberClients.addClient(3, "Лена", 100000D, new NumberPIN(4321));

        TerminalServer<Integer> server = new TerminalServer<>(sberClients);
        PINValidator<Integer> validator = new KeyboardPINValidator();
        ATM<Integer> bankomat = new ATM<>(validator, server);

        do {
            try {
                System.out.print("Введите номер счета: ");
                String accountOrExit = reader.readLine();
                if (accountOrExit.equals("exit")) break;
                Integer account = accountOrExit.isEmpty() ? 0 : Integer.parseInt(accountOrExit);
                System.out.print("Введите PIN-код: ");
                String pinStr = reader.readLine();
                Integer pin = pinStr.isEmpty() ? 0 : Integer.parseInt(pinStr);
                bankomat.checkClient(account, new NumberPIN(pin));
            } catch (IOException e) {
                System.out.println("\n=================================================================");
                System.out.println("Банкомат неисправен.\nВам следует обратиться к другому Банкомату.");
                System.out.println("=================================================================");
                break;
            } catch (NumberFormatException e) {
                System.out.println("\n=================================================================");
                System.out.println("Ожидается ввод номера счета и PIN-код.");
                System.out.println("=================================================================");
            }
        } while (true);
        System.out.println("Банкомат остановил работу.");
    }

}
