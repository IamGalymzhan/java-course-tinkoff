package edu.project2;

import java.util.List;

public class Main {
    private Main() {
    }

    @SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        Maze maze = new RecursiveBacktrackerGenerator().generate(31, 31);
        String unsolvedMaze = new ConsoleRenderer().render(maze);
        System.out.println(unsolvedMaze);
        List<Coordinate> path = new DfsSolver().solve(maze,
            new Coordinate(1, 1), new Coordinate(29, 29)
        );
        if (path != null) {
            String solvedMaze = new ConsoleRenderer().render(maze, path);
            System.out.println(solvedMaze);
        }
    }
}
