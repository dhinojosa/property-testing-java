package com.xyzcorp.junitquickcheck.verification;

import com.pholser.junit.quickcheck.Mode;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class VerificationProperties {

    /**
     * Runs the following property with whatever number of trials
     *
     * @param string1 property name
     * @param string2 property name
     */
    @Property(trials = 10)
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(String string1, String string2) {
        System.out.printf("%s, %s%n", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThanOrEqualTo(string1.length());
        assertThat(conc.length()).isGreaterThanOrEqualTo(string2.length());
    }


    /**
     * Exhaustive Mode will perform cartesian inputs, think nested for loop,
     * default is sampling
     * @param a integer for property
     * @param b integer for property
     */
    @Property(trials = 3, mode = Mode.EXHAUSTIVE)
    public void sumExhaustive(int a, int b) {
        System.out.printf("%d, %d%n", a, b);
    }
}
