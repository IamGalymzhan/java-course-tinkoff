package edu.project4.Render;

import edu.project4.Model.FractalImage;
import edu.project4.Model.Rect;
import edu.project4.Transformation.Transformation;
import java.util.List;

public interface Renderer {
    FractalImage render(
        FractalImage canvas,
        Rect world,
        List<Transformation> variations,
        int samples,
        int iterPerSample,
        int symmetry
        );
}
