package com.xyzcorp.jqwik.constraints;
import net.jqwik.api.*;
import net.jqwik.api.constraints.StringLength;

import static org.assertj.core.api.Assertions.*;

@Label("Constraints")
public class ConstraintProperties {

    @Property
    @Label("String Concatenation Length")
    public void concatenationLength(@ForAll @StringLength(min = 1, max = 20) String string1,
                                    @ForAll @StringLength(min = 1, max = 20) String string2) {
        String conc = string1 + string2;
        assertThat(conc.length()).isGreaterThan(string1.length());
        assertThat(conc.length()).isGreaterThan(string2.length());
    }
}
