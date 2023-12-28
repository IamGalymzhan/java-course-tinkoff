package edu.hw10.Task2;

import java.lang.reflect.Proxy;
import java.nio.file.Path;

public class CacheProxy {
    private CacheProxy() {
    }

    public static <T> T create(T object, Class<?> className, Path path) {
        return (T) Proxy.newProxyInstance(
            className.getClassLoader(),
            className.getInterfaces(),
            new CacheHandler(object, path));
    }
}
