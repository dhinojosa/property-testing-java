package com.xyzcorp.jqwik.properties;

import net.jqwik.api.*;

import static org.assertj.core.api.Assertions.*;

public class StringProperties {
    @Property
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
