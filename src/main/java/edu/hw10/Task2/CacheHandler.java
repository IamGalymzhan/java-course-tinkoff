package edu.hw10.Task2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CacheHandler implements InvocationHandler {

    private Map<Method, Map<List<Object>, Object>> memoryCache = new HashMap<>();
    private Object proxyObject;
    private Path path;
    private String fileSuffix = ".txt";

    public CacheHandler(Object object, Path path) {
        this.proxyObject = object;
        this.path = path;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            if (method.getAnnotation(Cache.class).persist()) {
                return diskSavedMethod(method, args);
            } else {
                return memorySavedMethod(method, args);
            }
        } else {
            return method.invoke(proxyObject, args);
        }
    }

    private Object memorySavedMethod(Method method, Object[] args)
        throws InvocationTargetException, IllegalAccessException {
        if (memoryCache.containsKey(method)
            && memoryCache.get(method).containsKey(Arrays.asList(args))) {
            return memoryCache.get(method).get(Arrays.asList(args));
        } else {
            Object result = method.invoke(proxyObject, args);
            var x = memoryCache.getOrDefault(method, new HashMap<>());
            x.put(Arrays.asList(args), result);
            memoryCache.put(method, x);
            return result;
        }
    }

    private Object diskSavedMethod(Method method, Object[] args)
        throws InvocationTargetException, IllegalAccessException {
        Object savedResult = readDiskSavedValue(method, args);
        if (savedResult == null) {
            Object result = method.invoke(proxyObject, args);
            writeDiskSavedValue(method, args, result);
            return result;
        } else {
            return savedResult;
        }
    }

    private Object readDiskSavedValue(Method method, Object[] args) {
        Path methodPath = path.resolve(method.getName());
        if (!Files.exists(methodPath)) {
            try {
                Files.createDirectories(methodPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Path argsPath = methodPath.resolve(Arrays.asList(args).toString() + fileSuffix);
        if (!Files.exists(argsPath)) {
            return null;
        }
        try (ObjectInputStream ois = new ObjectInputStream(
            new BufferedInputStream(
                new FileInputStream(argsPath.toFile())
            )
        )) {
            return ois.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeDiskSavedValue(Method method, Object[] args, Object result) {
        Path argsPath = path.resolve(method.getName()).resolve(Arrays.asList(args).toString() + fileSuffix);
        try (ObjectOutputStream oos = new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream(argsPath.toFile())
            )
        )) {
            oos.writeObject(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
