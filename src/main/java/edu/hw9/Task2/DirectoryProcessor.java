package edu.hw9.Task2;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class DirectoryProcessor {
    private static final ForkJoinPool FORK_JOIN_POOL = ForkJoinPool.commonPool();

    public static List<String> directoriesWithMoreThanNumberFiles(Path path) {
        return null;
    }

    public static List<String> filesByPredicate(Path path, Predicate<Path> predicate) {
        return null;
    }
}
