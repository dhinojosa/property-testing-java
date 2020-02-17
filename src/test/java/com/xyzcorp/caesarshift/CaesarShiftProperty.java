package com.xyzcorp.caesarshift;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;

import static org.assertj.core.api.Assertions.assertThat;

public class CaesarShiftProperty {

    @Property
    void verifyThatCaesarShiftWorksForAllAlpha(
        @ForAll @AlphaChars String string,
        @ForAll int shift) {
        assertThat(
            CaesarShift
                .decode(CaesarShift.encode(string, shift), shift))
                .isEqualTo(string);
    }
}
