package ru.malychev.jstasks.proxy;

public interface CalculatorActions {
    @CacheIt(cache = false)
    double sqr(double x);

    @CacheIt(cache = true)
    double cube(double x);

    @CacheIt(cache = true)
    double sqrt(double x);

}
