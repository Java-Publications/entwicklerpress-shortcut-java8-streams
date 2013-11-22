package org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.unsorted_yet;


import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by Sven Ruppert on 18.11.13.
 */
public class Part07 {


    public static void main(String[] args) {
        final Stream<Long> fibStream = makeFibStream(10);
        fibStream.forEachOrdered(System.out::println);

        System.out.println("isPrime(7) = " + isPrime(7));

    }

    public static boolean isPrime(int n) {
        return n >= 2 && IntStream.rangeClosed(2, (int) (Math.sqrt(n))).allMatch((d) -> n % d != 0);
    }

    public static Stream<Long> makeFibStream() {
        return(Stream.generate(new FibonacciSupplier()));
    }
    public static Stream<Long> makeFibStream(int numFibs) {
        return(makeFibStream().limit(numFibs));
    }
    public static List<Long> makeFibList(int numFibs) {
        return(makeFibStream(numFibs).collect(Collectors.toList()));
    }

    public static class FibonacciSupplier implements Supplier<Long> {
        private long previous = 0;
        private long current = 1;
        @Override
        public Long get() {
            long next = current + previous;
            previous = current;
            current = next;
            return(previous);
        }
    }

}