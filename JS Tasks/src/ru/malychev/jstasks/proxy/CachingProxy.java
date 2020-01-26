package ru.malychev.jstasks.proxy;

import java.lang.reflect.Proxy;

public class CachingProxy {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        HandleCalculator handleCalculator = new HandleCalculator(calculator);

        CalculatorActions calculatorActions = (CalculatorActions) Proxy.newProxyInstance(
                CalculatorActions.class.getClassLoader(),
                new Class[] {CalculatorActions.class},
                handleCalculator);

        System.out.println("2 в квадрате = " + calculatorActions.sqr(2.0) + "\n");
        System.out.println("2 в кубе = " + calculatorActions.cube(2.0) + "\n");
        System.out.println("Корень квадратный из 2 = " + calculatorActions.sqrt(2.0) + "\n");
        System.out.println("===============================================");
        System.out.println("3 в квадрате = " + calculatorActions.sqr(3.0) + "\n");
        System.out.println("3 в кубе = " + calculatorActions.cube(3.0) + "\n");
        System.out.println("Корень квадратный из 3 = " + calculatorActions.sqrt(3.0) + "\n");
        System.out.println("===============================================");
        System.out.println("2 в квадрате = " + calculatorActions.sqr(2.0) + "\n");
        System.out.println("2 в кубе = " + calculatorActions.cube(2.0) + "\n");
        System.out.println("Корень квадратный из 2 = " + calculatorActions.sqrt(2.0) + "\n");

    }
}
