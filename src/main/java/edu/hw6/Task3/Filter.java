package edu.hw6.Task3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.regex.Pattern;

public class Filter {
    public static final AbstractFilter REGULAR_FILE = Files::isRegularFile;
    public static final AbstractFilter READABLE = Files::isReadable;

    private Filter() {
    }

    public static AbstractFilter largerThan(int size) {
        return (path -> Files.size(path) > size);
    }

    public static AbstractFilter extensionIs(String extension) {
        return (path -> path.toString().endsWith("." + extension));
    }

    public static AbstractFilter globMatches(String glob) {
        return (path -> FileSystems.getDefault().getPathMatcher("glob:" + glob)
            .matches(path.getFileName()));
    }

    public static AbstractFilter regexContains(String regex) {
        return (path -> Pattern.compile(regex).matcher(path.toString()).find());
    }

    public static AbstractFilter magicNumber(byte... bytes) {
        return (path -> {
            try {
                byte[] fileBytes = Files.readAllBytes(path);
                if (bytes.length > fileBytes.length) {
                    return false;
                }
                for (int i = 0; i < bytes.length; i++) {
                    if (bytes[i] != fileBytes[i]) {
                        return false;
                    }
                }
                return false;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
