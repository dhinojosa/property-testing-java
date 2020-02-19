package com.xyzcorp.junitquickcheck.customshrinking;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.fail;

@RunWith(JUnitQuickcheck.class)
public class CustomShrinkingProperties {
    @Property
    public void testPointDistance(@From(PointGenerator.class) Point p1,
                                  @From(PointGenerator.class) Point p2) {
        fail();
    }
}
