package com.xyzcorp.vavr.nullgenerators;

import io.vavr.Tuple2;
import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NullGeneratorProperties {

    @Test
    public void testLengthPropertyWithStringOrNull() {
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
                    System.out.printf("s1 = %s, s2 = %s%n", s1, s2);
                    return true;
                })
                .check()
                .assertIsSatisfied();
    }


    @Test
    void testLengthPropertyWithStringOrNullWithFrequency() {
        Arbitrary<String> stringOrNull = new Arbitrary<String>() {
            @Override
            public Gen<String> apply(int size) {
                Arbitrary<String> stringArbitrary = Arbitrary.string
                    (Gen.oneOf(Gen.choose('a', 'z'),
                        Gen.choose('A', 'Z')));

                return Gen.frequency(
                    new Tuple2<>(90, stringArbitrary.apply(size)),
                    new Tuple2<>(10, Gen.of(null)));
            }
        };

        Property.def("length(string1 + string2) > length(string1) + length(string2)")
                .forAll(stringOrNull, stringOrNull)
                .suchThat((s1, s2) -> {
                    System.out.printf("s1 = %s, s2 = %s%n", s1, s2);
                    return true;
                })
                .check()
                .assertIsSatisfied();
    }
}
