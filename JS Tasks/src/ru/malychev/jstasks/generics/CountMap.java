package ru.malychev.jstasks.generics;

import java.util.Map;

public interface CountMap<T> {

    // добавляет элемент в этот контейнер.
     void add(T element);

    //Возвращает количество добавлений данного элемента
    int getCount(T element);

    //Уменьшает количество удаляемого элемента на 1, и возвращает новое значение.
    //Либо удаляет последний элемент из контейнера, возвращая 0
    int remove(T element);

    //Очищает контейнер от всех элементов
    void clear();

    //количество разных элементов
    int size();

    //Добавить все элементы из source в текущий контейнер при совпадении ключей, суммировать значения
    void addAll(CountMap<? extends T> source);

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    Map<? extends T, Integer> toMap();

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    void toMap(Map<? super T, Integer> destination);

}
