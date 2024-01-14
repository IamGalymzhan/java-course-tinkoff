package edu.project4;

import edu.project4.Image.ImageFormat;
import edu.project4.Image.ImageUtils;
import edu.project4.ImageProcessor.ImageProcessor;
import edu.project4.Model.FractalImage;
import edu.project4.Model.Rect;
import edu.project4.Render.Renderer;
import edu.project4.Transformation.Transformation;
import java.nio.file.Path;
import java.util.List;

public class FractalFlameGenerator {

    private FractalImage fractalImage;
    private Rect world;
    private Renderer renderer;
    private List<Transformation> transformations;
    private ImageProcessor imageProcessor;

    public FractalFlameGenerator(
        int width,
        int height,
        Rect world,
        Renderer renderer,
        List<Transformation> transformations,
        ImageProcessor imageProcessor
    ) {
        this.fractalImage = FractalImage.create(width, height);
        this.world = world;
        this.renderer = renderer;
        this.transformations = transformations;
        this.imageProcessor = imageProcessor;
    }

    public void generate(int samples, int iterPerSample, int symmetry, Path path, ImageFormat imageFormat) {
        fractalImage = renderer.render(fractalImage, world, transformations, samples, iterPerSample, symmetry);
        imageProcessor.process(fractalImage);
        ImageUtils.save(fractalImage, path, imageFormat);
    }
}
