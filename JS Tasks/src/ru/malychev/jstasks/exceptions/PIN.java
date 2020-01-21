package ru.malychev.jstasks.exceptions;

public abstract class PIN<T> {
    T pin;
    PIN(T pin) {
        this.pin = pin;
    }

    public abstract boolean equals(PIN<T> pin);
    public abstract  T getPIN();
}
