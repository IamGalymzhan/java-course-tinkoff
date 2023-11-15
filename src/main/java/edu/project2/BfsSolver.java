package edu.project2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BfsSolver implements Solver {
    private Cell[][] grid;
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int height;
    private int width;
    private List<Coordinate> path;
    private int[][] visited;
    private Coordinate[][] parent;
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
        parent = new Coordinate[height][width];

        if (!isInside(startX, startY) || grid[startX][startY].type() == Cell.Type.WALL) {
            return null;
        }
        if (!isInside(endX, endY) || grid[endX][endY].type() == Cell.Type.WALL) {
            return null;
        }

        path = new ArrayList<>();
        boolean result = bfs();

        if (!result) {
            return null;
        }

        getPath();

        return path;
    }

    private boolean bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(startX, startY));
        while (!queue.isEmpty()) {
            Coordinate peek = queue.peek();
            int x = peek.row();
            int y = peek.col();
            queue.remove();
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int k = 0; k < DIRECTIONS; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (isInside(nx, ny) && visited[nx][ny] == 0 && grid[nx][ny].type() != Cell.Type.WALL) {
                    visited[nx][ny] = 1;
                    queue.add(new Coordinate(nx, ny));
                    parent[nx][ny] = new Coordinate(x, y);
                }
            }
        }
        return visited[endX][endY] == 1;
    }

    private void getPath() {
        int x = endX;
        int y = endY;
        path.add(new Coordinate(x, y));
        while (x != startX || y != startY) {
            Coordinate temp = parent[x][y];
            x = temp.row();
            y = temp.col();
            path.add(temp);
        }
        path.reversed();
    }

    private boolean isInside(int x, int y) {
        return x >= 0 && x < height && y >= 0 && y < width;
    }
}
