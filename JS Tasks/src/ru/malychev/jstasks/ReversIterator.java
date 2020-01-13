package ru.malychev.jstasks;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ReversIterator<T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public ReversIterator(List<T> list) {
        this.list = list;
        index = list.size() - 1;
    }

    public boolean hasNext() {
        return index > -1;
    }

    public T next() throws NoSuchElementException {
        if (hasNext()) return list.get(index--);
        else throw new NoSuchElementException("Достигнуто начало списка: " + list +
                                              "\nБольше элементов нет!");
    }
}
