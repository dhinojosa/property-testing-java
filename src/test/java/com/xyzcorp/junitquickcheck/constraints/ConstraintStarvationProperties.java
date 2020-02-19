package com.xyzcorp.junitquickcheck.constraints;


import com.pholser.junit.quickcheck.Mode;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class ConstraintStarvationProperties {
    @Property(mode = Mode.SAMPLING)
    public void testPrimality(@InRange(minInt = 2, maxInt = 10) Integer i) {
        System.out.printf("%d%n", i);
        assertTrue(true);
    }
}
