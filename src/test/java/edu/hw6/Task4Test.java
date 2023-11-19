package edu.hw6;

import edu.hw6.Task4.CompositionWriter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {

    private Path path = Paths.get(".").resolve("data");
    private String fileName = "quote.txt";
    @Test
    void test() {
        CompositionWriter.writeWithComposition(path.resolve(fileName));
        assertThat(Files.exists(path.resolve(fileName))).isTrue();
        try {
            assertThat(Files.readAllLines(path.resolve(fileName)))
                .containsExactly("Programming is learned by writing programs. ― Brian Kernighan", "");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    void after() {
        try {
            Files.delete(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
