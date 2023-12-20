package edu.project4.Render;

import edu.project4.Model.AffineCoefficients;
import edu.project4.Model.Pixel;
import edu.project4.Model.Point;

public abstract class AbstractRenderer implements Renderer {

    protected static final int START = -20;

    protected static Point applyAffineCoefficients(Point point, AffineCoefficients affineCoefficients) {
        return new Point(
            point.x() * affineCoefficients.a() + point.y() * affineCoefficients.b() + affineCoefficients.c(),
            point.x() * affineCoefficients.d() + point.y() * affineCoefficients.e() + affineCoefficients.f()
        );
    }

    protected static Point rotatePoint(Point point, double theta) {
        double newX = point.x() * Math.cos(theta) - point.y() * Math.sin(theta);
        double newY = point.x() * Math.sin(theta) + point.y() * Math.cos(theta);
        return new Point(newX, newY);
    }

    protected static void colorPixel(Pixel pixel, AffineCoefficients affineCoefficients) {
        if (pixel.getHitCount() == 0) {
            pixel.setR(affineCoefficients.color().getRed());
            pixel.setG(affineCoefficients.color().getGreen());
            pixel.setB(affineCoefficients.color().getBlue());
        } else {
            pixel.setR((pixel.getR() + affineCoefficients.color().getRed()) / 2);
            pixel.setG((pixel.getG() + affineCoefficients.color().getGreen()) / 2);
            pixel.setB((pixel.getB() + affineCoefficients.color().getBlue()) / 2);
        }
        pixel.setHitCount(pixel.getHitCount() + 1);
    }
}
