package ru.malychev.jstasks.exceptions;

import ru.malychev.jstasks.exceptions.bankexceptions.AccountNotFoundException;
import ru.malychev.jstasks.exceptions.bankexceptions.IncorrectPINException;

public class KeyboardPINValidator extends PINValidator<Integer> {

    private static int countEnterPIN = 0;
    private final int maxQuantityEnterPIN = 3;

    boolean checkPIN(int account, PIN<Integer> pin, TerminalServer<Integer> server)  throws AccountNotFoundException, IncorrectPINException {
        countEnterPIN++;
        boolean correctPIN = server.getPINClient(account).equals(pin);
        if (correctPIN) {
            countEnterPIN = 0;
            return true;
        } else {
            countEnterPIN++;
            throw new IncorrectPINException(maxQuantityEnterPIN - countEnterPIN);
        }
    }

    int getCountEnterPIN() {
        return countEnterPIN;
    }
}
