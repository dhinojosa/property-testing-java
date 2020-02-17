package com.xyzcorp.junitquickcheck.constraints;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ConstraintProperties {

    @Property
    public void concatenationLength(String s1,
                                    String s2) {

        assumeThat(s1.length()).isLessThan(5);
        assumeThat(s2.length()).isLessThan(5);

        System.out.printf("S1 = %s\tS2=%s", s1, s2);
        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }
}
