package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class ParallelDfsSolver implements Solver {
    private Cell[][] grid;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int height;
    private int width;
    private List<Coordinate> path;
    private int[][] visited;
    private static final int DIRECTIONS = 4;

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        startX = start.row();
        startY = start.col();
        endX = end.row();
        endY = end.col();
        height = maze.getHeight();
        width = maze.getWidth();
        this.grid = maze.getGrid();
        visited = new int[height][width];

        if (!isInside(startX, startY) || grid[startX][startY].type() == Cell.Type.WALL) {
            return null;
        }
        if (!isInside(endX, endY) || grid[endX][endY].type() == Cell.Type.WALL) {
            return null;
        }

        path = new ArrayList<>();
        path.add(new Coordinate(startX, startY));

        boolean result = dfs(startX, startY);

        if (!result) {
            return null;
        }

        return path;
    }

    private boolean dfs(int x, int y) {
        if (x == endX && y == endY) {
            return true;
        }
        visited[x][y] = 1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < DIRECTIONS; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (isInside(nx, ny) && grid[nx][ny].type() == Cell.Type.PASSAGE && visited[nx][ny] == 0) {
                path.add(new Coordinate(nx, ny));
                boolean result = dfs(nx, ny);
                if (result) {
                    return true;
                }
                path.removeLast();
            }
        }
        return false;
    }

    private boolean isInside(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    private class Dfs extends RecursiveTask<Boolean> {
        int x;
        int y;

        Dfs(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        protected Boolean compute() {
            if (x == endX && y == endY) {
                return true;
            }
            visited[x][y] = 1;
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            List<Dfs> forks = new ArrayList<>();

            for (int k = 0; k < DIRECTIONS; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (isInside(nx, ny) && grid[nx][ny].type() == Cell.Type.PASSAGE && visited[nx][ny] == 0) {
                    path.add(new Coordinate(nx, ny));
                    Dfs task = new Dfs(nx, ny);
                    forks.add(task);
                    path.removeLast();
                }
            }
            for (var fork : forks) {
                boolean result = fork.join();
                if (result) {
                    return true;
                }
            }
            return false;
        }
    }

}
