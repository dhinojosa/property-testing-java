package com.xyzcorp.junitquickcheck.nullgenerators;


import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.internal.generator.NullAllowed;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import com.xyzcorp.junitquickcheck.generators.CustomGenerator;
import org.junit.runner.RunWith;

import javax.annotation.Nullable;
import java.util.Objects;

@RunWith(JUnitQuickcheck.class)
public class NullGeneratorProperties {
    @Property
    public void countryProperty(@Nullable Integer x,
                                @Nullable Integer y) {
        System.out.format("x=%s y=%s%n",
            Objects.toString(x, "null"),
            Objects.toString(y, "null"));
    }

    @Property
    public void countryProperty(@From(CustomGenerator.class)
                                @NullAllowed(probability = 0.1f)
                                    String countries1,
                                @From(CustomGenerator.class)
                                @NullAllowed(probability = 0.1f)
                                    String countries2) {
        System.out.format("%s,%s%n", countries1, countries2);
    }
}
