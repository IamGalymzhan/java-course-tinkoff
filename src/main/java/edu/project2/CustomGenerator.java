package edu.project2;

public class CustomGenerator {
    private CustomGenerator() {
    }

    public static Maze createMaze(int height, int width, String[] mazeInput) {
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (mazeInput[i].charAt(j) == ' ') {
                    grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                } else {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }
        return new Maze(height, width, grid);
    }
}
