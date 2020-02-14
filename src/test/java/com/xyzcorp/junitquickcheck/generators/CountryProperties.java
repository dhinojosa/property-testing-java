package com.xyzcorp.junitquickcheck.generators;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

@RunWith(JUnitQuickcheck.class)
public class CountryProperties {
    @Property()
    public void countryProperty(String countries) {
        System.out.println(countries);
    }
}
