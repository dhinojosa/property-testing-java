package com.xyzcorp.junitquickcheck.customshrinking;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PointGenerator extends Generator<Point> {
    private static final Point ORIGIN = new Point(0, 0);

    public PointGenerator() {
        super(Point.class);
    }

    @Override
    public Point generate(
        SourceOfRandomness random,
        GenerationStatus status) {

        return new Point(random.nextInt(), random.nextInt());
    }

    @Override
    public List<Point> doShrink(
        SourceOfRandomness random,
        Point larger) {

        System.out.printf("Running the shrink process for %s%n", larger);

        if (ORIGIN.equals(larger))
            return Collections.emptyList();

        List<Point> shrinks = new ArrayList<>();
        shrinks.add(new Point(0, larger.getY()));
        shrinks.add(new Point(larger.getX(), 0));
        shrinks.add(new Point(larger.getX() / 2, larger.getY()));
        shrinks.add(new Point(larger.getX(), larger.getY() / 2));

        System.out.printf("Offering the following options: %s%n", shrinks);
        return shrinks;
    }
}
