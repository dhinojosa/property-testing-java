package com.xyzcorp.jqwik.constraints;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Label("Constraints with Starvation")
public class ConstraintStarvationProperties {
    @Property
    @Label("There are only nine values")
    public void testPrimality(@ForAll @IntRange(min=2, max = 10) Integer i) {
        assertTrue(true);
    }
}
