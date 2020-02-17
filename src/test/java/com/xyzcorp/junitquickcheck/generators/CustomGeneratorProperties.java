package com.xyzcorp.junitquickcheck.generators;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class CustomGeneratorProperties {
    @Property()
    public void countryProperty(@From(CustomGenerator.class) String country) {
        System.out.println(country);
    }
}
