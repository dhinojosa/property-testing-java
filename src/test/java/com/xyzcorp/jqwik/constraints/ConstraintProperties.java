package com.xyzcorp.jqwik.constraints;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.StringLength;

import static org.assertj.core.api.Assertions.assertThat;

@Label("Constraints")
public class ConstraintProperties {
    @Property
    @Label("String Concatenation Length")
    public void concatenationLengthIsGreaterThanEitherOfTheOriginals
        (@ForAll @StringLength(min = 5, max = 5) String string1,
         @ForAll @StringLength(min = 5, max = 5) String string2) {

        System.out.format("%s,%s\n", string1, string2);
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
