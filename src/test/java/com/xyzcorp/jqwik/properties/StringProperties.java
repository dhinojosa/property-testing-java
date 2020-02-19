package com.xyzcorp.jqwik.properties;

import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.*;

/**
 * This property test will fail.
 * Notice the types of characters that are created.
 * Notice what it told me was the issue
 */
public class StringProperties {
    @Property
    void concatenationLengthIsGreaterThanEitherOfTheOriginals(
        @ForAll String string1, @ForAll String string2) {
        System.out.format("%s, %s\n", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
