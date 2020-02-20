package com.xyzcorp.junitquickcheck.ctorgen;

import java.util.Objects;
import java.util.StringJoiner;

public class Dollars {

    private int dollars;

    public Dollars(int dollars) {
        this.dollars = dollars;
    }

    public int getDollars() {
        return dollars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dollars dollars1 = (Dollars) o;
        return dollars == dollars1.dollars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dollars);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Dollars.class.getSimpleName() + "[", "]")
            .add("dollars=" + dollars)
            .toString();
    }
}
