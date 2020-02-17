package com.xyzcorp.jqwik.verification;

import net.jqwik.api.AfterFailureMode;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

import static org.assertj.core.api.Assertions.assertThat;

public class VerificationProperties {

    @Property(tries = 20)
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(@ForAll String string1, @ForAll String string2) {
        System.out.printf("%s %s", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }

    @Property(afterFailure = AfterFailureMode.SAMPLE_ONLY)
    void lengthOfConcatenatedStringIsGreaterThanLengthOfEachSampleOnly(@ForAll String string1, @ForAll String string2) {
        System.out.printf("%s %s", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
