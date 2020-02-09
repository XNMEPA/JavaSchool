package ru.malychev.jstasks.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Fibonacci {
    static int maxNumber = 50;
    static List<Long[]> list = new ArrayList<>(maxNumber);

    static BiConsumer<Integer, Long> printMember = (index, memberFibonacci) -> System.out.println("Fib[ " + index + " ] = " + memberFibonacci);

    public static void fibonacci(int index, long a, long b, BiConsumer<Integer, Long> printMember) {
        if (index > maxNumber) return;
        printMember.accept(index, b);
        fibonacci(++index, b, a + b, printMember);
    }

    public static void fibonacci(long a, Consumer<String> show) {
        long c, b = a;
        String str;
        for (int i = 1; i <= maxNumber ; i++) {
            str= "Feb[" + i + "] = " + a;
            show.accept(str);
            c = a; a = b; b +=c;
        }
    }

    public static long fibonacci (long a, long b, long i) {
        if (i <= maxNumber) {
            Long[] pair = new Long[2];
            pair[0] = i;
            pair[1] = fibonacci(b, a+b, ++i);
            list.add(pair);
        }

        return a;
    }

    public static void main(String[] args) {

        System.out.println("Простой цикл.");
        for (long a = 0, b = 1, c, i = 1; i <= maxNumber; i++) {
            System.out.println("Fib[ " + i + " ] = " + b);
            c = a; a = b; b += c;
        }

        System.out.println("\nПередача в метод переменную с лямбда-выражением.");
        fibonacci(1, 0, 1, printMember);

        System.out.println("\nПоток по списку.");
       fibonacci(0, 1, 1);
        list.stream()
            .sorted((a, b) ->  (int) (a[0] - b[0]))
            .map(f -> "Feb[" + f[0] + "] = " + f[1])
            .forEach(System.out::println);

        System.out.println("\nТак себе вариант. Передается ссылка на метод.");
        fibonacci(1, System.out::println);

        System.out.println("\nГенарация чисел Фибоначчи в потоке.");
        Stream.iterate(
                new Long[] { 0L, 1L, 1L },
                f -> new Long[] { f[1], f[0] + f[1], ++f[2]})
                .map(f -> "Fib[" + f[2] + "] = " + f[1])
                .limit(maxNumber)
                .forEach(System.out::println);

    }

}
