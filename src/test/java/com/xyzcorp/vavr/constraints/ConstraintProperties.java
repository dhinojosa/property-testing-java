package com.xyzcorp.vavr.constraints;

import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class ConstraintProperties {

    Arbitrary<String> fiveLetterAlphaWords = Arbitrary.string(
        Gen.oneOf(Gen.choose('a', 'z'),
            Gen.choose('a', 'z'))).filter(w -> w.length() >= 5)
                                                      .map(w -> w.substring(0
                                                          , 5));

    @Test
    public void constrainTheStringLength() {
        Property.def("length(string1 + string2) > length(string1) + length" +
            "(string2)")
                .forAll(fiveLetterAlphaWords, fiveLetterAlphaWords)
                .suchThat((string1, string2) -> {
                    System.out.format("%s,%s\n", string1, string2);
                    return true;
                })
                .check()
                .assertIsSatisfied();
    }
}
