package ru.malychev.jstasks.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HandleCalculator implements InvocationHandler {
    private final CalculatorActions calculator;
    private Cache cache;

    public HandleCalculator(CalculatorActions calculator) {
        this.calculator = calculator;
        cache = new Cache();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        Double result = null;
        CacheIt cacheIt = method.getAnnotation(CacheIt.class);
        if (!cacheIt.cache()) {
            System.out.println("Метод не кешируется в соответствии с аннотацией.");
            System.out.println("Вычисление произведено оригинальным методом.");
            result = (Double) method.invoke(calculator, args);
        } else {
            try {
                result = cache.get(method.getName(), (Double) args[0]);
                if (result == null) {
                    System.out.println("Данные в кеше не найдены.");
                    System.out.println("Вычисление произведено оригинальным методом.");
                    result = (Double) method.invoke(calculator, args);
                    cache.put(method.getName(), (Double) args[0], result);
                } else System.out.println("Результат выбран из кеша.");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
