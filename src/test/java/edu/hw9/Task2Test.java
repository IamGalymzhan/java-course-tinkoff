package edu.hw9;

import edu.hw9.Task2.DirectoryProcessor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    Path path = Paths.get(".").resolve("data");
    @BeforeEach
    void before() {
        try {
            Files.createDirectories(path);
            Files.createFile(path.resolve("File.txt"));
            Files.createFile(path.resolve("ok.zip"));
            Files.createFile(path.resolve("text.txt"));
            Files.createFile(path.resolve("no.rar"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Test file counter")
    void test1() {
        List<String> expectedResult = List.of(path.toString());

        List<String> actualResult = DirectoryProcessor.directoriesWithMoreThanNumberFiles(path, 4);

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @Test
    @DisplayName("Test file filter")
    void test2() {
        List<String> expectedResult = List.of(
            path.resolve("File.txt").toString(),
            path.resolve("text.txt").toString()
        );

        List<String> actualResult = DirectoryProcessor.filesByPredicate(path,
            p -> p.toString().endsWith(".txt"));

        assertThat(actualResult).containsExactlyInAnyOrderElementsOf(expectedResult);
    }

    @AfterEach
    void after() {
        try {
            Files.delete(path.resolve("File.txt"));
            Files.delete(path.resolve("ok.zip"));
            Files.delete(path.resolve("text.txt"));
            Files.delete(path.resolve("no.rar"));
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
