package com.xyzcorp.junitquickcheck.customshrinking;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.ShrinkingMode;
import net.jqwik.api.constraints.IntRange;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomShrinkingProperties {

    public List<Integer> badReverse(List<Integer> integers) {
        if (integers.size() > 4) return integers;
        else {
            Collections.reverse(integers);
            return integers;
        }
    }

    @Property(shrinking = ShrinkingMode.FULL)
    public void testReverse(@ForAll List<Integer> list) {
        var result = badReverse(list);
        list.stream()
            .mapToInt(x -> x)
            .max()
            .ifPresent(x -> assertThat(result.get(result.size() -1)).isEqualTo(x));
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

    @Property(shrinking = ShrinkingMode.FULL)
    public void testPrimality(@ForAll @IntRange(min=2) Integer i) {
        assertTrue(checkIfPrime((long) i));
    }
}
