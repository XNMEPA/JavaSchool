package ru.malychev.jstasks.generics;

public abstract class Apple {
    private String name;

    Apple(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
