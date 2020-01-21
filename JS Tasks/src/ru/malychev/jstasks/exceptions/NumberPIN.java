package ru.malychev.jstasks.exceptions;

public class NumberPIN extends PIN<Integer> {

    NumberPIN(Integer pin) {
        super(pin);
    }

    public Integer getPIN() {
        return pin;
    }

    public boolean equals(PIN<Integer> pin) {
        return this.pin.intValue() == pin.pin.intValue();
    }
}
