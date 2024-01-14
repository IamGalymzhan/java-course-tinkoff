package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class FilterFiles extends RecursiveTask<List<String>> {

    private Path path;
    private Predicate<Path> predicate;

    public FilterFiles(Path path, Predicate<Path> predicate) {
        this.path = path;
        this.predicate = predicate;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        List<FilterFiles> forks = new ArrayList<>();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
            for (Path curPath : paths) {
                if (Files.isRegularFile(curPath)) {
                    if (predicate.test(curPath)) {
                        result.add(curPath.toString());
                    }
                } else if (Files.isDirectory(curPath)) {
                    FilterFiles task = new FilterFiles(curPath, predicate);
                    task.fork();
                    forks.add(task);
                }
            }
            for (var task : forks) {
                result.addAll(task.join());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
