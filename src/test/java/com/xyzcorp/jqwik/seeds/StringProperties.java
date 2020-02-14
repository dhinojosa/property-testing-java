package com.xyzcorp.jqwik.seeds;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class StringProperties {
    @Property(seed="422663427220294220")
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
