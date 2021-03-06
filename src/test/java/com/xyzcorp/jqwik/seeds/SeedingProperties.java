package com.xyzcorp.jqwik.seeds;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class SeedingProperties {

    /**
     * This method runs through the same set over and over again
     * since we have the same seed
     *
     * @param string1 first randomly created string
     * @param string2 second randomly created string
     */
    @Property(seed = "-7133490007600192627")
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
