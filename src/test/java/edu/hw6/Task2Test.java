package edu.hw6;

import edu.hw6.Task2.FileCloner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    Path path = Paths.get(".").resolve("data");
    private static String fileName = "TestingName.txt";
    private static String fileNameCopy = "TestingName - копия.txt";
    private static String fileNameCopy2 = "TestingName - копия (2).txt";
    @BeforeEach
    void before() {
        try {
            Files.createFile(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void test() {
        FileCloner.cloneFile(path.resolve(fileName));
        assertThat(Files.exists(path.resolve(fileNameCopy))).isTrue();
        FileCloner.cloneFile(path.resolve(fileName));
        assertThat(Files.exists(path.resolve(fileNameCopy2))).isTrue();
    }

    @AfterEach
    void after() {
        try {
            Files.delete(path.resolve(fileName));
            Files.delete(path.resolve(fileNameCopy));
            Files.delete(path.resolve(fileNameCopy2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
