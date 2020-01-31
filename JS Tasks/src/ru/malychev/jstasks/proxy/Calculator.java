package ru.malychev.jstasks.proxy;

public class Calculator implements CalculatorActions {

    @Override
    public double sqr(double x) {
        return x * x;
    }

    @Override
    public double cube(double x) {
        return x * x * x;
    }

    @Override
    public double sqrt(double x) {
        return Math.sqrt(x);
    }
}
