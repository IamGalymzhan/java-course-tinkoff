package edu.project4.Transformation;

import edu.project4.Model.Point;

public class EyefishTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);
        return new Point(2.0 / (r + 1) * x, 2.0 / (r + 1) * y);
    }
}
