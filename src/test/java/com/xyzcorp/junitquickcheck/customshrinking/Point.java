package com.xyzcorp.junitquickcheck.customshrinking;

import java.util.Objects;
import java.util.StringJoiner;

public class Point {
    private int y;
    private int x;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return y == point.y &&
            x == point.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
            .add("y=" + y)
            .add("x=" + x)
            .toString();
    }
}
