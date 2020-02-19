package com.xyzcorp.vavr.verification;

import io.vavr.Tuple;
import io.vavr.control.Option;
import io.vavr.test.Arbitrary;
import io.vavr.test.Gen;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class VerificationProperties {

    private Arbitrary<String> strings = Arbitrary.string(
        Gen.oneOf(
            Gen.choose('a', 'z'),
            Gen.choose('A', 'Z')));

    /**
     * check will provide opportunity to change the size, and the tries that
     * it will take before failing.
     */
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

    /**
     * You can return a sample of what failed the property
     */
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


    /**
     * Count returns the number of checks
     */
    @Test
    public void testWithCount() {

        int count = Property.def("length(string1 + string2) > length(string1)" +
            " + length(string2)")
                            .forAll(strings, strings)
                            .suchThat((s1, s2) -> {
                                String conc = s1 + s2;
                                return conc.length() > s1.length() && conc.length() > s2.length();
                            })
                            .check()
                            .count();

        System.out.println(count);
    }
}
