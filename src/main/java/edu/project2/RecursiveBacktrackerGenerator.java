package edu.project2;

import java.util.Random;

public class RecursiveBacktrackerGenerator implements Generator {

    private int height = 0;
    private int width = 0;
    private Random random = new Random();
    private int[][] maze = null;

    @Override
    public Maze generate(int height, int width) {
        Cell[][] grid = new Cell[height][width];
        int magicX = 0;
        int magicY = 0;
        this.height = height - magicX;
        this.width = width - magicY;
        this.maze = new int[height][width];
        for (int i = 0; i < height - magicX; i++) {
            for (int j = 0; j < width - magicY; j++) {
                maze[i][j] = 1;
            }
        }

        createMaze(1, 1);

        for (int i = 0; i < height - magicX; i++) {
            for (int j = 0; j < width - magicY; j++) {
                if (maze[i][j] == 0) {
                    grid[i][j] = new Cell(i, j, Cell.Type.PASSAGE);
                } else {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == null) {
                    grid[i][j] = new Cell(i, j, Cell.Type.WALL);
                }
            }
        }

        return new Maze(height, width, grid);
    }

    @SuppressWarnings("MagicNumber")
    private void createMaze(int x, int y) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int[] directions = {0, 1, 2, 3};
        shuffleArray(directions);

        for (int dir : directions) {
            int nx = x + dx[dir] * 2;
            int ny = y + dy[dir] * 2;

            if (isInside(nx, ny) && maze[ny][nx] == 1) {
                maze[y + dy[dir]][x + dx[dir]] = 0;
                maze[ny][nx] = 0;
                createMaze(nx, ny);
            }
        }
    }

    private boolean isInside(int x, int y) {
        return x > 0 && x < height - 1 && y > 0 && y < width - 1;
    }

    private void shuffleArray(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
