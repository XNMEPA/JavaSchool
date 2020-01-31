package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

import java.util.Date;

public class KeyboardPINValidator extends PINValidator<Integer> {

    private static int countEnterPIN = 0;
    private final int maxQuantityEnterPIN = 3;
    private static Date endTimeLock = new Date(0);
    private final int timeLock = 10000;

    boolean checkPIN(int account, PIN<Integer> pin, TerminalServer<Integer> server)  throws AccountNotFoundException, IncorrectPINException {
        countEnterPIN++;
        boolean correctPIN = server.getPINClient(account).equals(pin);
        if (correctPIN) {
            countEnterPIN = 0;
            return true;
        } else if (countEnterPIN < maxQuantityEnterPIN){
            throw new IncorrectPINException(maxQuantityEnterPIN - countEnterPIN);
        } else {
            endTimeLock.setTime(new Date().getTime() + timeLock);
            System.out.println("Счет заблокирован.\nРазблокировка произойдет через " + timeLock / 1000 + " секунд.");
            countEnterPIN = 0;
            return false;
        }
    }

    Date getEndTimeLock() {
        return endTimeLock;
    }
}
