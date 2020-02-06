package ru.malychev.jstasks.fibonacci;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Fibonacci {

    public static void main(String[] args) {

//        for (long a = 1, b = 1, c, i = 0; i < 50; i++) {
//            System.out.println("a = " + a);
//            c = a; a = b ; b += c;

        fibonacci(0, 1, (i, a) -> {
            long c, b = a;
            System.out.println("Fib[ " + i + " ] = " + a);
            c = a; a = b; b +=c;
        });
    }
    public static void fibonacci(int i, long a, BiConsumer<Integer, Long> show) {
        show.accept(i, a);
    }
}
