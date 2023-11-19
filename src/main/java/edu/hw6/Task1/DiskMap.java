package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String>, AutoCloseable {

    private int size = 0;
    private String uniqueName = "";
    private Path path = null;

    private String readValue(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            String value = reader.readLine();
            if (value != null) {
                return value;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private void writeValue(Path path, String value) throws IOException {
        Files.createDirectories(path.getParent());
        Files.write(path, value.getBytes());
    }

    private void removeValue(Path path) {
        try {
            Files.delete(path);
        } catch (Exception e) {

        }
    }

    public DiskMap() {
        uniqueName = UUID.randomUUID().toString();
        path = Paths.get(".");
        path = path.resolve("data\\" + uniqueName);
        try {
            Files.createDirectories(path);
        } catch (Exception e) {

        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.skip(1).anyMatch(x -> x.getFileName().toString().equals((String) key));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean containsValue(Object value) {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.skip(1).map(x -> readValue(x)).anyMatch(x -> x.equals((String) value));
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String get(Object key) {
        String value = readValue(path.resolve((String) key));
        return value;
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        try {
            String oldValue = get(key);
            writeValue(path.resolve((String) key), value);
            size++;
            return oldValue;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String remove(Object key) {
        String oldValue = get(key);
        removeValue(path.resolve((String) key));
        if (oldValue != null) {
            size--;
        }
        return oldValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        for (var entry : m.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            put(key, value);
        }
    }

    @Override
    public void clear() {
        size = 0;
        try (Stream<Path> paths = Files.walk(path)) {
            paths.skip(1).forEach(x -> {
                try {
                    Files.delete(x);
                } catch (IOException e) {

                }
            });
        } catch (Exception e) {

        }
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.skip(1).map(x -> x.getFileName().toString())
                .collect(Collectors.toSet());
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    @Override
    public Collection<String> values() {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.skip(1).map(x -> readValue(x))
                .collect(Collectors.toSet());
        } catch (Exception e) {
            return null;
        }
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        try (Stream<Path> paths = Files.walk(path)) {
            return paths.skip(1)
                .collect(Collectors.toMap(x -> x.getFileName().toString(), x -> readValue(x)))
                .entrySet();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void close() {
        clear();
        try {
            Files.delete(path);
        } catch (Exception e) {

        }
    }
}
