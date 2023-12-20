package edu.project4.Transformation;

import edu.project4.Model.Point;

public class CylinderTransformation implements Transformation {
    @Override
    public Point apply(Point point) {
        return new Point(Math.sin(point.x()), point.y());
    }
}
