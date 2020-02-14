package com.xyzcorp.vavr.nullgenerators;

import io.vavr.Tuple2;
import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class StringProperties {

    @Test
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach() {

        Arbitrary<String> stringOrNull = new Arbitrary<String>() {
            @Override
            public Gen<String> apply(int size) {
                Arbitrary<String> stringArbitrary = Arbitrary.string
                    (Gen.oneOf(Gen.choose('a', 'z'), Gen.choose('A', 'Z')));

                return Gen.oneOf(stringArbitrary.apply(size), Gen.of(null));
            }
        };

        Property.def("length(string1 + string2) > length(string1) + length" +
            "(string2)")
                .forAll(stringOrNull, stringOrNull)
                .suchThat((s1, s2) -> {
                    String conc = s1 + s2;
                    return conc.length() >= s1.length() && conc.length() >= s2.length();
                })
                .check()
                .assertIsSatisfied();
    }
}
