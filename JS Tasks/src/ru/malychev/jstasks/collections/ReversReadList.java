package ru.malychev.jstasks.collections;

import java.util.Iterator;
import java.util.List;

public class ReversReadList<T>  implements Iterable<T> {
    private List<T> list;

    public ReversReadList(List<T> list) {
        this.list = list;
    }

    public T get(Integer i) {
        return list.get(i);
    }

    @Override
    public Iterator<T> iterator() {
        return new ReversIterator<>(this.list);
    }
}
