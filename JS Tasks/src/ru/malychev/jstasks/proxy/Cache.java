package ru.malychev.jstasks.proxy;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<Double, Double> cacheSQR;
    private Map<Double, Double> cacheSQRT;
    private Map<Double, Double> cacheCube;

    public Cache() {
        cacheSQR = new HashMap<>();
        cacheSQRT = new HashMap<>();
        cacheCube = new HashMap<>();
    }

    public void put(String method, Double value, Double result) throws NoSuchMethodException {
        switch (method) {
            case "sqrt":
                cacheSQRT.put(value, result);
                break;
            case "cube":
                cacheCube.put(value, result);
                break;
            case "sqr":
                cacheSQR.put(value, result);
                break;
            default: throw new  NoSuchMethodException("Метод не определен!");
        }
    }

    public Double get(String method, Double value) throws NoSuchMethodException {
        System.out.println("Производится выгрузка данных из кеша.");
        switch (method) {
            case "sqrt":
                return cacheSQRT.get(value);
            case "cube":
                return cacheCube.get(value);
            case "sqr":
                return cacheSQR.get(value);
            default: throw new  NoSuchMethodException("Метод не определен!");
        }
    }
}
