package com.xyzcorp.junitquickcheck.ctorgen;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.Ctor;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnitQuickcheck.class)
public class CustomCtorProperties {
    @Property
    public void testPointDistance(@From(Ctor.class) Dollars c1,
                                  @From(Ctor.class) Dollars c2) {
        System.out.printf("%s %s%n", c1, c2);
        assertTrue(true);
    }
}
