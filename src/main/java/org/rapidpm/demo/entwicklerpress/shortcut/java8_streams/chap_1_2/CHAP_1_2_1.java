package org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.chap_1_2;

import java.util.List;
import java.util.function.Consumer;

import org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.Pair;
import org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.PairListGenerator;

/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_1 {
    public static void main(String[] args) {
        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();

        //pre JDK8
        for (final Pair generateDemoValue : generateDemoValues) {
            System.out.println(generateDemoValue);
        }

        //long version
        generateDemoValues.stream().forEach(v -> System.out.println(v) );

        //short version
        generateDemoValues.stream().forEach(System.out::println);
        generateDemoValues.parallelStream().forEach(System.out::println);


        generateDemoValues.stream().forEachOrdered(System.out::println);
        generateDemoValues.parallelStream().forEachOrdered(System.out::println);


        final Consumer<? super Pair> consumer = System.out::println;
        generateDemoValues.stream().forEachOrdered(consumer);
        generateDemoValues.parallelStream().forEachOrdered(consumer);

    }

}
