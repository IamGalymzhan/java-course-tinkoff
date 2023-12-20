package edu.project4.Transformation;

import edu.project4.Model.Point;
import java.util.concurrent.ThreadLocalRandom;

public class BladeTransformation implements Transformation {

    double psi = ThreadLocalRandom.current().nextDouble(1.0);

    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);

        return new Point(
            x * (Math.cos(psi * r * x) + Math.sin(psi * r * x)),
            x * (Math.cos(psi * r * y) + Math.sin(psi * r * x))
        );
    }
}
