package ru.malychev.jstasks.generics;

import java.util.HashMap;
import java.util.Map;

public class CountContainer<T> implements CountMap<T> {

    private Map<T, Integer> map;

    //конструктор создает внутренний HashMap
    public CountContainer() {
        map = new HashMap<>();
    }

    // добавляет элемент в этот контейнер.
    public void add(T element) {
        if (map.containsKey(element)) map.put(element, map.get(element) + 1);
        else map.put(element, 1);
    }

    //Возвращает количество добавлений данного элемента
    public int getCount(T element) {
        return map.getOrDefault(element, 0);
    }

    //Уменьшает количество удаляемого элемента на 1, и возвращает новое значение.
    //Либо удаляет последний элемент из контейнера, возвращая 0
    public int remove(T element) {
        if (map.get(element) != null) {
            int i = map.get(element);
            if (i > 1) {
                map.put(element, --i);
                return i;
            }
            else return map.remove(element);
        }
        return 0;
    }

    //Очищает контейнер от всех элементов
    public void clear() {
        map.clear();
    }

    //количество разных элементов
    public int size() {
        return map.size();
    }

    //Вернуть java.util.Map. ключ - добавленный элемент, значение - количество его добавлений
    public Map<? extends T, Integer> toMap() {
        return new HashMap<>(map);
    }

    //Тот же самый контракт как и toMap(), только всю информацию записать в destination
    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(map);
    }

    //Добавить все элементы из source в текущий контейнер при совпадении ключей, суммировать значения
    public void addAll(CountMap<? extends T> source) {
        for (Map.Entry<? extends T, Integer> pair: source.toMap().entrySet())
            if(map.containsKey(pair.getKey())) map.put(pair.getKey(), map.get(pair.getKey()) + pair.getValue());
            else map.put(pair.getKey(), pair.getValue());
    }

}
