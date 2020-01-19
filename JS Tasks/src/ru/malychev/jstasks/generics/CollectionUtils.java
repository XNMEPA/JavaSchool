package ru.malychev.jstasks.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class  CollectionUtils<T> {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<? super T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T > source, T t) {
        return source.indexOf(t);
    }

    public static <T> List<? extends T> limit(List<? extends T> source, int size) {
        if (source.size() > size) return source.subList(0, size - 1);
        else return source.subList(0, source.size() - 1);
    }

    public static <T> void add(List<? super T> source, T t) {
        source.add(t);
    }

    public static <T> boolean removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        return removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T t : c2)
            if(c1.contains(t)) return true;
        return false;
    }

    public static <T> List<? extends T> range(List<? extends T> list, T min, T max) {
        list.sort(new Match<T>());
        return list.subList(list.indexOf(min), list.lastIndexOf(max));
    }

    public static <T> List<? extends T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        list.sort(comparator);
        return list.subList(list.indexOf(min), list.lastIndexOf(max));
    }

}
