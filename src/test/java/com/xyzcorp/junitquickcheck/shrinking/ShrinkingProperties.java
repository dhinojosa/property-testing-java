package com.xyzcorp.junitquickcheck.shrinking;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class ShrinkingProperties {

    private long highestPrimeNumberSoFar;

    public List<Integer> badReverse(List<Integer> integers) {
        if (integers.size() > 4) return integers;
        else {
            Collections.reverse(integers);
            return integers;
        }
    }

    @Property(shrink = true, maxShrinks = 10000, maxShrinkDepth = 400)
    public void testSorting(List<Integer> list) {
        var result = badReverse(list);
        list.stream()
            .mapToInt(x -> x)
            .max()
            .ifPresent(x -> assertThat(result.get(result.size() - 1)).isEqualTo(x));
    }


    @Property(shrink = true, maxShrinks = 10000, maxShrinkDepth = 400)
    public void testOutsideSorting(List<Integer> list) {
        var result = badReverse(list);
        OptionalInt max = list.stream()
                              .mapToInt(x -> x)
                              .max();

        if (max.isEmpty()) {
            assertTrue(true);
        } else {
            assertThat(result.get(result.size() - 1)).isEqualTo(max.getAsInt());
        }
    }

    @Property()
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
        String string1,
        String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }

    public static boolean checkIfPrime(long number) {

        if (number < 1) {
            return false;
        }
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.floor(Math.sqrt(number)) + 1; i = i + 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @RunWith(JUnitQuickcheck.class)
    public static class IntegerProperties {
        @Property(shrink = true, maxShrinks = 10000, maxShrinkDepth = 400)
        public void primality(@InRange(minInt = 2) int i) {
            assertTrue(checkIfPrime((long) i));
        }
    }
}
