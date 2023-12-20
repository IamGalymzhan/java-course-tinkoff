package edu.project4.Image;

import edu.project4.Model.FractalImage;
import edu.project4.Model.Pixel;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public final class ImageUtils {
    private ImageUtils() {
    }

    public static void save(FractalImage image, Path filename, ImageFormat format) {
        BufferedImage bufferedImage = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                Pixel pixel = image.pixel(i, j);
                bufferedImage.setRGB(i, j, new Color(pixel.getR(), pixel.getG(), pixel.getB()).getRGB());
            }
        }

        try {
            ImageIO.write(bufferedImage, format.name(), filename.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
