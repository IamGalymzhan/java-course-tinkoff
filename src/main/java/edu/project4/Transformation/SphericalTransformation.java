package edu.project4.Transformation;

import edu.project4.Model.Point;

public class SphericalTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        return new Point(x / (x * x + y * y), y / (x * x + y * y));
    }
}
