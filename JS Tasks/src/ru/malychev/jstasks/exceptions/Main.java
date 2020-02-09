package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountIsLockedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        String accountOrExit;
        int account;
        String pinStr;
        int pin;

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
                accountOrExit = reader.readLine();
                if (accountOrExit.equals("exit")) break;
                account = accountOrExit.isEmpty() ? 0 : Integer.parseInt(accountOrExit);
                System.out.print("Введите PIN-код: ");
                pinStr = reader.readLine();
                pin = pinStr.isEmpty() ? 0 : Integer.parseInt(pinStr);
                if (bankomat.checkClient(account, new NumberPIN(pin))) {
                    System.out.println("Меню клиента:");
                    System.out.println("1. Проверить баланс.");
                    System.out.println("2. Снять наличные.");
                    System.out.println("3. Положить средства на счет.");
                    System.out.println("4. Закончить сеанс.");
                    System.out.println("Введите номер пункта меню: ");
                }
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
