package edu.project4.Model;

import java.util.concurrent.ThreadLocalRandom;

public record Rect(double x, double y, double width, double height) {
    public boolean contains(Point point) {
        return (point.x() >= x && point.x() <= x + width) && (point.y() >= y && point.y() <= y + height);
    }

    public Point randomPoint() {
        return new Point(
            ThreadLocalRandom.current().nextDouble(x, x + width),
            ThreadLocalRandom.current().nextDouble(y, y + height)
        );
    }
}
