package edu.project4;

import edu.project4.Image.ImageFormat;
import edu.project4.ImageProcessor.GammaImageProcessor;
import edu.project4.Model.Rect;
import edu.project4.Render.DefaultRenderer;
import edu.project4.Render.ParallelRenderer;
import edu.project4.Transformation.BladeTransformation;
import edu.project4.Transformation.CylinderTransformation;
import edu.project4.Transformation.DiskTransformation;
import edu.project4.Transformation.EyefishTransformation;
import edu.project4.Transformation.HeartTransformation;
import edu.project4.Transformation.PolarTransformation;
import edu.project4.Transformation.SinusoidTransformation;
import edu.project4.Transformation.SphericalTransformation;
import edu.project4.Transformation.TangentTransformation;
import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FractalFlameGeneratorTest {

    @Test
    void test() {
        FractalFlameGenerator fractalFlameGenerator = new FractalFlameGenerator(
            1920,
            1080,
            new Rect(-4, -3, 8, 6),
            //new Rect(-1.777, -1, 3.554, 2),
            new ParallelRenderer(),
            List.of(
                new CylinderTransformation()
            ),
            new GammaImageProcessor()
        );
        Path path = Paths.get("C:\\MyDocs\\image.png");
        fractalFlameGenerator.generate(6, 1_000_000, 6, path, ImageFormat.PNG);
    }
}
