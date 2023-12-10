package edu.hw9.Task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MoreThanXFiles extends RecursiveTask<List<String>> {

    Path path;
    int minFiles;

    public MoreThanXFiles(Path path, int minFiles) {
        this.path = path;
        this.minFiles = minFiles;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        int fileCount = 0;
        List<MoreThanXFiles> forks = new ArrayList<>();
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(path)) {
            for (Path curPath : paths) {
                if (Files.isRegularFile(curPath)) {
                    fileCount++;
                } else if (Files.isDirectory(curPath)) {
                    MoreThanXFiles task = new MoreThanXFiles(curPath, minFiles);
                    task.fork();
                    forks.add(task);
                }
            }
            if (fileCount >= minFiles) {
                result.add(path.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
