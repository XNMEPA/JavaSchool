package ru.malychev.jstasks.generics;

import java.util.Comparator;

public class Match<T> implements Comparator<T> {

    public int compare(T t1, T t2) {
        if (t1.hashCode() == t2.hashCode()) return 0;
        else return t1.hashCode() > t2.hashCode() ? 1 : -1;
    }
}
