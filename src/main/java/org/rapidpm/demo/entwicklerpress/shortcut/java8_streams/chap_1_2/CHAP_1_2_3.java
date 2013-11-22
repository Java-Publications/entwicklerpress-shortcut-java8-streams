package org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.chap_1_2;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.PairListGenerator;
import org.rapidpm.demo.entwicklerpress.shortcut.java8_streams.Pair;


/**
 * Created by Sven Ruppert on 22.11.13.
 */
public class CHAP_1_2_3 {

    public static void main(String[] args) {
        final List<Pair> generateDemoValues = new PairListGenerator(){}.generateDemoValues();


        //map from Point to DemoElements
        final Stream<DemoElement> demoElementStream = generateDemoValues.stream().map(v -> {
            final String value = v.getValue();
            final DemoElement d = new DemoElement();
            d.setDatum(new Date());
            d.setValue(Base64.getEncoder().encodeToString(value.getBytes()));
            return d;
        });


        final Stream<Pair> filteredPairStream = generateDemoValues.stream().filter(v -> v.getId() % 2 == 0);






    }

}
