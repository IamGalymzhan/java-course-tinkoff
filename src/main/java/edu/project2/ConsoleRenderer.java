package edu.project2;

import java.util.List;

public class ConsoleRenderer implements Renderer {
    public String render(Maze maze) {
        StringBuilder st = new StringBuilder();
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j].type() == Cell.Type.WALL) {
                    st.append("▉");
                } else {
                    st.append(" ");
                }
            }
            st.append("\n");
        }
        return st.toString();
    }

    public String render(Maze maze, List<Coordinate> path) {
        StringBuilder st = new StringBuilder();
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] grid = maze.getGrid();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j].type() == Cell.Type.WALL) {
                    st.append("▉");
                } else {
                    if (path.contains(new Coordinate(i, j))) {
                        st.append(".");
                    } else {
                        st.append(" ");
                    }
                }
            }
            st.append("\n");
        }
        return st.toString();
    }
}
