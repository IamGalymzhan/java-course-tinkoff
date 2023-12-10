package edu.hw9.Task2;

import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;

public class DirectoryProcessor {

    private DirectoryProcessor() {
    }

    private static final ForkJoinPool FORK_JOIN_POOL = ForkJoinPool.commonPool();

    public static List<String> directoriesWithMoreThanNumberFiles(Path path, int minFiles) {
        List<String> result;
        result = FORK_JOIN_POOL.invoke(new MoreThanXFiles(path, minFiles));
        FORK_JOIN_POOL.shutdown();
        return result;
    }

    public static List<String> filesByPredicate(Path path, Predicate<Path> predicate) {
        List<String> result;
        result = FORK_JOIN_POOL.invoke(new FilterFiles(path, predicate));
        FORK_JOIN_POOL.shutdown();
        return result;
    }
}
