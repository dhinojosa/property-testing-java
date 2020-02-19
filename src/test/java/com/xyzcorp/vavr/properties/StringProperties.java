package com.xyzcorp.vavr.properties;

import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

/**
 * Notice that this has no real involvement with the testing framework
 *
 * Also notice that there is more involvement in how we create strings
 *
 * This uses something called an <code>Arbitrary</code> to create
 * these elements.
 *
 * Also notice that we are not using an assertion language construct here, we
 * are using a boolean
 */
public class StringProperties {
    @Test
    public void concatenationLengthIsGreaterThanEitherOfTheOriginals() {
        Arbitrary<String> strings = Arbitrary.string(
            Gen.oneOf(
                Gen.choose('a', 'z'),
                Gen.choose('A', 'Z')));

        Property.def("length(string1 + string2) > length(string1) + length" +
            "(string2)")
                .forAll(strings, strings)
                .suchThat((s1, s2) -> {
                    System.out.printf("%s, %s", s1, s2);
                    String conc = s1 + s2;
                    return conc.length() > s1.length() && conc.length() > s2.length();
                })
                .check()
                .assertIsSatisfied();
    }
}
