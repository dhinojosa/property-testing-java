package com.xyzcorp.junitquickcheck.seeds;


import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.When;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class SeedingProperties {
    /**
     * This method runs through the same set over and over again
     * since we have the same seed
     *
     * @param string1 first randomly created string
     * @param string2 second randomly created string
     */
    @Property
    public void lengthOfConcatenatedStringIsGreaterThanLengthOfEach(
        @When(seed=3259717668655695955L) String string1,
        @When(seed=1491891169778846883L) String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
