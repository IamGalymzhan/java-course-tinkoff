package edu.project2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RendererTest {
    @Test
    @DisplayName("Maze")
    void test() {
        Maze maze = new PrimGenerator().generate(16, 16);
        String mazeString = new ConsoleRenderer().render(maze);
        System.out.println(mazeString);
    }
}
