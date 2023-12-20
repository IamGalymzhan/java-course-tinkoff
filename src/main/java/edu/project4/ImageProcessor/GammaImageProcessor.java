package edu.project4.ImageProcessor;

import edu.project4.Model.FractalImage;
import edu.project4.Model.Pixel;

public class GammaImageProcessor implements ImageProcessor {

    private static final double GAMMA = 2.0;

    @Override
    public void process(FractalImage image) {
        double max = 0;
        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                Pixel pixel = image.pixel(i, j);
                if (pixel.getHitCount() != 0) {
                    pixel.setNormal(Math.log10(pixel.getHitCount()));
                    if (pixel.getNormal() > max) {
                        max = pixel.getNormal();
                    }
                }
            }
        }
        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                Pixel pixel = image.pixel(i, j);
                double normal = pixel.getNormal() / max;
                pixel.setR((int) (pixel.getR() * Math.pow(normal, 1 / GAMMA)));
                pixel.setG((int) (pixel.getG() * Math.pow(normal, 1 / GAMMA)));
                pixel.setB((int) (pixel.getB() * Math.pow(normal, 1 / GAMMA)));
            }
        }
    }
}
