package com.xyzcorp.vavr.verification;

import io.vavr.Tuple;
import io.vavr.control.Option;
import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class StringProperties {

    private Arbitrary<String> strings = Arbitrary.string(
        Gen.oneOf(
            Gen.choose('a', 'z'),
            Gen.choose('A', 'Z')));

    @Test
    public void testWithCheckAndSizeTries() {
        Property.def("length(string1 + string2) > length(string1) + length" +
            "(string2)")
                .forAll(strings, strings)
                .suchThat((s1, s2) -> {
                    String conc = s1 + s2;
                    return conc.length() > s1.length() && conc.length() > s2.length();
                })
                .check(200, 20)
                .assertIsSatisfied();
    }

    @Test
    public void testWithSample() {
        Option<Tuple> sample =
            Property.def("length(string1 + string2) > length(string1) + length(string2)")
                    .forAll(strings, strings)
                    .suchThat((s1, s2) -> {
                        String conc = s1 + s2;
                        return conc.length() > s1.length() && conc.length() > s2.length();
                    })
                    .check()
                    .sample();

        System.out.println(sample);
    }
}
