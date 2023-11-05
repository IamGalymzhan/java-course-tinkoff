package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class DfsSolverTest {
    @Test
    @DisplayName("Common case")
    void test() {
        String[] mazeInput = {
            " ▉▉ ▉ ",
            "  ▉  ▉",
            "     ▉",
            " ▉ ▉ ▉",
            " ▉    "
        };

        Maze maze = CustomGenerator.createMaze(5, 6, mazeInput);
        List<Coordinate> path = new DfsSolver().solve(maze,
            new Coordinate(0, 0), new Coordinate(4, 5));

        assertThat(path).isNotNull();
        String mazeString = new ConsoleRenderer().render(maze, path);
        System.out.println(mazeString);
    }

    @Test
    @DisplayName("Start is wall")
    void test2() {
        String[] mazeInput = {
            "▉▉▉ ▉ ",
            "  ▉  ▉",
            "     ▉",
            " ▉ ▉ ▉",
            " ▉    "
        };

        Maze maze = CustomGenerator.createMaze(5, 6, mazeInput);
        List<Coordinate> path = new DfsSolver().solve(maze,
            new Coordinate(0, 0), new Coordinate(4, 5));

        assertThat(path).isNull();
    }

    @Test
    @DisplayName("End is wall")
    void test3() {
        String[] mazeInput = {
            " ▉▉ ▉ ",
            "  ▉  ▉",
            "     ▉",
            " ▉ ▉ ▉",
            " ▉   ▉"
        };

        Maze maze = CustomGenerator.createMaze(5, 6, mazeInput);
        List<Coordinate> path = new DfsSolver().solve(maze,
            new Coordinate(0, 0), new Coordinate(4, 5));

        assertThat(path).isNull();
    }

    @Test
    @DisplayName("No solution")
    void test4() {
        String[] mazeInput = {
            " ▉▉ ▉ ",
            "  ▉  ▉",
            "     ▉",
            " ▉▉▉▉▉",
            " ▉    "
        };

        Maze maze = CustomGenerator.createMaze(5, 6, mazeInput);
        List<Coordinate> path = new DfsSolver().solve(maze,
            new Coordinate(0, 0), new Coordinate(4, 5));

        assertThat(path).isNull();
    }
}
