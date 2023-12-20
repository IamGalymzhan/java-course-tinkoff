package edu.project4.Render;

import edu.project4.Model.AffineCoefficients;
import edu.project4.Model.FractalImage;
import edu.project4.Model.Pixel;
import edu.project4.Model.Point;
import edu.project4.Model.Rect;
import edu.project4.Transformation.Transformation;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DefaultRenderer extends AbstractRenderer {
    private AffineCoefficients[] affineCoefficientsArray;

    @Override
    public FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        int symmetry
    ) {
        affineCoefficientsArray = new AffineCoefficients[samples];
        for (int i = 0; i < samples; ++i) {
            affineCoefficientsArray[i] = AffineCoefficients.create();
        }
        for (int num = 0; num < samples; ++num) {
            Point pw = world.randomPoint();
            for (int step = START; step < iterPerSample; ++step) {
                int affineCoefficientsIndex = ThreadLocalRandom.current().nextInt(samples);
                AffineCoefficients affineCoefficients = affineCoefficientsArray[affineCoefficientsIndex];
                pw = applyAffineCoefficients(pw, affineCoefficients);

                int variationIndex = ThreadLocalRandom.current().nextInt(variations.size());
                Transformation variation = variations.get(variationIndex);
                pw = variation.apply(pw);

                if (step >= 0 && world.contains(pw)) {
                    double theta2 = 0.0;
                    for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                        Point pwr = rotatePoint(pw, theta2);
                        if (!world.contains(pwr)) {
                            continue;
                        }

                        int pixelX = (int) ((pwr.x() - world.x()) * canvas.width() / world.width());
                        int pixelY = (int) ((pwr.y() - world.y()) * canvas.height() / world.height());

                        Pixel pixel = canvas.pixel(pixelX, pixelY);
                        if (pixel == null) {
                            continue;
                        }
                        colorPixel(pixel, affineCoefficients);
                    }
                }
            }
        }
        return canvas;
    }

}
