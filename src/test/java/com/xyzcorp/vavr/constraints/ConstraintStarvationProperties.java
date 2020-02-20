package com.xyzcorp.vavr.constraints;


import io.vavr.test.Arbitrary;
import io.vavr.test.Property;
import org.junit.jupiter.api.Test;

public class ConstraintStarvationProperties {

    @Test
    public void testPrimality() {
        Arbitrary<Integer> integer = Arbitrary.integer().filter(i -> i > 2 && i <= 10).distinct();
        Property.def("Testing primality with too few numbers")
                .forAll(integer)
                .suchThat(i -> {
                    System.out.printf("i = %d%n", i);
                    return true;})
                .check()
                .assertIsSatisfied();
    }
}
