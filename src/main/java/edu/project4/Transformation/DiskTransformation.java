package edu.project4.Transformation;

import edu.project4.Model.Point;

public class DiskTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);
        return new Point(
            Math.atan(y / x) / Math.PI * Math.sin(r),
            Math.atan(y / x) / Math.PI * Math.cos(r)
        );
    }
}
