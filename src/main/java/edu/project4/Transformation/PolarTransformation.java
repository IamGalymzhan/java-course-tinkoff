package edu.project4.Transformation;

import edu.project4.Model.Point;

public class PolarTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        return new Point(Math.atan(y / x) / Math.PI, Math.sqrt(x * x + y * y) - 1);
    }
}
