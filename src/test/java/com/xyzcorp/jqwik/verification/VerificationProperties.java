package com.xyzcorp.jqwik.verification;

import net.jqwik.api.AfterFailureMode;
import net.jqwik.api.ForAll;
import net.jqwik.api.GenerationMode;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.CharRange;
import net.jqwik.api.constraints.IntRange;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationProperties {

    /**
     * tries - different sets of parameter values
     * @param string1
     * @param string2
     */
    @Property(tries = 20)
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        System.out.printf("%s %s", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }

    @Property(tries = 30, generation = GenerationMode.EXHAUSTIVE)
    void lengthOfConcatenatedStringExhaustive(@ForAll @IntRange(min=0, max=2) int i,
                                              @ForAll @CharRange(from='a', to='d') char c) {
        System.out.printf("%d, %s", i, c);
    }
}
