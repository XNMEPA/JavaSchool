package ru.malychev.jstasks.fibonacci;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Fibonacci {

    public static void main(String[] args) {

//        for (long a = 1, b = 1, c, i = 0; i < 50; i++) {
//            System.out.println("a = " + a);
//            c = a; a = b ; b += c;

        fibonacci(50, 1, (i, a) -> {
            System.out.println("Fib[ " + i + " ] = " + a);
         });
    }
    public static void fibonacci(int n, long a, BiConsumer<Integer, Long> show) {
        long c, b = a;
        for (int i = 0; i < n ; i++) {
            show.accept(i, a);
            c = a; a = b; b +=c;
        }
    }
}
