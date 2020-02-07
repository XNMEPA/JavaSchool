package ru.malychev.jstasks.fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Fibonacci {
    static int maxNumber = 50;
    static List<Long> list = new ArrayList<>(maxNumber);

    static BiConsumer<Integer, Long> printMember = (index, memberFibonacci) -> System.out.println("Fib[ " + index + " ] = " + memberFibonacci);

    public static void fibonacci(int index, long a, long b, BiConsumer<Integer, Long> printMember) {
        if (index > maxNumber) return;
        printMember.accept(index, b);
        fibonacci(++index, b, a + b, printMember);
    }

    public static void fibonacci(long a, BiConsumer<Integer, Long> show) {
        long c, b = a;
        for (int i = 1; i <= maxNumber ; i++) {
            show.accept(i, a);
            c = a; a = b; b +=c;
        }
    }

    public static long fibonacci (long a, long b, int i) {
        if (i < maxNumber)
            list.add(fibonacci(b, a+b, ++i));
        return a;
    }

    public static void main(String[] args) {

/*        for (long a = 0, b = 1, c, i = 1; i <= maxNumber; i++) {
            System.out.println("Fib[ " + i + " ] = " + b);
            c = a; a = b; b += c;
        }
*/

//        fibonacci(1, 0, 1, printMember);

/*        fibonacci(0, 1, 1);
        list.stream()
            .sorted()
            .forEach(System.out::println);
*/
/*        fibonacci(50, 1, (i, a) -> {
            System.out.println("Fib[ " + i + " ] = " + a);
         });
*/
        Stream.iterate(
                new Long[] { 0L, 1L, 1L },
                f -> new Long[] { f[1], f[0] + f[1], ++f[2]})
                .map(f -> "Fib[" + f[2] + "] = " + f[1])
                .limit(maxNumber)
                .forEach(System.out::println);

    }

}
