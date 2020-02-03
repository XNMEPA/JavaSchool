package ru.malychev.jstasks.serializingproxy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by "XNMEPA" on 02.02.2020.
 * Определение условий кеширования результатов методов {@link Result}
 */

public class Result implements Serializable {
    private String nameFunction;
    private double argument;
    private long timeStamp = 0L;
    private double result = 0.0;

    public Result(String nameFunction, double argument) {
        this.nameFunction = nameFunction;
        this.argument = argument;
    }

    public Result initialize(double result, long timeStamp) {
        this.result = result;
        this.timeStamp = timeStamp;
        return this;
    }

    public String getNameFunction() {
        return nameFunction;
    }

    public double getArgument() {
        return argument;
    }

    @Override
    public boolean equals(Object res) {
        if (this == res) return true;
        if (res == null || getClass() != res.getClass()) return false;
        Result result = (Result) res;
        try {
            Class<?>[] classes = Service.class.getMethod("calc", Result.class).getDeclaredAnnotation(Cache.class).identityBy();
            if (classes.length == 0)
                return this.nameFunction.equals(result.nameFunction) &&
                        Double.compare(result.argument, this.argument) == 0 &&
                        this.timeStamp == result.timeStamp;
            else if (classes[0] == String.class && classes[1] == double.class)
                return this.nameFunction.equals(result.nameFunction) &&
                        Double.compare(result.argument, this.argument) == 0;
        } catch (NoSuchMethodException e) {
            System.err.println("Ошибка аннотирования метода \"calc\".\nМетод пропал из сервиса Исполнения Желаний.");
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFunction, argument, result);
    }

    @Override
    public String toString() {
        return nameFunction + "(" + argument + ")" + " = " + result + " : " + timeStamp;
    }
}
