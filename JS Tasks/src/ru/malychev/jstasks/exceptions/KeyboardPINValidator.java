package ru.malychev.jstasks.exceptions;

public class KeyboardPINValidator implements PinValidator<Integer> {

    private static int countEnterPIN = 0;
    private final int maxQuantityEnterPIN = 3;

    public boolean checkPIN(PIN<Integer> pin, Account account) {
        return true;
    }
}
