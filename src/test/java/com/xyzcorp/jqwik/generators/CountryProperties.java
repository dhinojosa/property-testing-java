package com.xyzcorp.jqwik.generators;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;

public class CountryProperties {
    @Property
    public void countryProperty(@ForAll("countries") String countries) {
        System.out.println(countries);
    }
}
