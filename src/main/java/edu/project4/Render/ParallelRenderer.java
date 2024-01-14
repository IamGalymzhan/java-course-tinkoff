package edu.project4.Render;

import edu.project4.Model.AffineCoefficients;
import edu.project4.Model.FractalImage;
import edu.project4.Model.Pixel;
import edu.project4.Model.Point;
import edu.project4.Model.Rect;
import edu.project4.Transformation.Transformation;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ParallelRenderer extends AbstractRenderer {
    private static final int THREADS = 4;
    private static final long AWAIT_TIME = 20;
    private ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
    private AffineCoefficients[] affineCoefficientsArray = null;
    private FractalImage canvas;

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
        this.canvas = canvas;
        for (int num = 0; num < samples; ++num) {
            executorService.submit(() -> {
                processSample(world, variations, iterPerSample, symmetry);
            });
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(AWAIT_TIME, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.canvas;
    }

    private void processSample(
        Rect world,
        List<Transformation> variations,
        int iterPerSample,
        int symmetry
    ) {
        Point pw = world.randomPoint();
        for (int step = START; step < iterPerSample; ++step) {
            int affineCoefficientsIndex = ThreadLocalRandom.current().nextInt(affineCoefficientsArray.length);
            AffineCoefficients affineCoefficients = affineCoefficientsArray[affineCoefficientsIndex];
            pw = applyAffineCoefficients(pw, affineCoefficients);

            int variationIndex = ThreadLocalRandom.current().nextInt(variations.size());
            Transformation variation = variations.get(variationIndex);
            pw = variation.apply(pw);

            if (step >= 0) {
                double theta2 = 0.0;
                for (int s = 0; s < symmetry; theta2 += Math.PI * 2 / symmetry, ++s) {
                    Point pwr = rotatePoint(pw, theta2);
                    if (!world.contains(pwr)) {
                        continue;
                    }

                    int pixelX = (int) ((pwr.x() - world.x()) * this.canvas.width() / world.width());
                    int pixelY = (int) ((pwr.y() - world.y()) * this.canvas.height() / world.height());

                    Pixel pixel = this.canvas.pixel(pixelX, pixelY);
                    if (pixel == null) {
                        continue;
                    }
                    synchronized (pixel) {
                        colorPixel(pixel, affineCoefficients);
                    }
                }
            }
        }
    }
}
