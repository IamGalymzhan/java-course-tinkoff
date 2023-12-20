package edu.project4.Model;

public record FractalImage(Pixel[][] data, int width, int height) {
    public static FractalImage create(int width, int height) {
        Pixel[][] data = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = new Pixel(0, 0, 0, 0, 0);
            }
        }
        return new FractalImage(data, width, height);
    }

    boolean contains(int x, int y) {
        return (x >= 0 && x < width) && (y >= 0 && y < height);
    }

    public Pixel pixel(int x, int y) {
        if (!contains(x, y)) {
            return null;
        }
        return data[x][y];
    }

}
