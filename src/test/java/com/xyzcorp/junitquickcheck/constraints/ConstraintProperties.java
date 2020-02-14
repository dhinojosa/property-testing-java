package com.xyzcorp.junitquickcheck.constraints;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Size;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitQuickcheck.class)
public class ConstraintProperties {

    @Property
    public void concatenationLength(@Size(min = 1, max = 20) String s1,
                                    @Size(min = 1, max = 20) String s2) {
        System.out.printf("S1 = %s\tS2=%s", s1, s2);
        assertEquals(s1.length() + s2.length(), (s1 + s2).length());
    }
}
