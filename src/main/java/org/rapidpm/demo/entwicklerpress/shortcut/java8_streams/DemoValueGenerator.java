package org.rapidpm.demo.entwicklerpress.shortcut.java8_streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.chap_1_3.Worker;

/**
 * Created by Sven Ruppert on 12.11.13.
 */
public interface DemoValueGenerator {

    public default List<Integer> generateDemoValuesForY() {
        final Random random = new Random();
        return Stream
                .generate(() -> random.nextInt(Worker.MAX_GENERATED_INT))
                .limit(Worker.ANZAHL_MESSWERTE)
                .collect(Collectors.toList());

    }
}
