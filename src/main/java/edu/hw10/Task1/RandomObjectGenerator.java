package edu.hw10.Task1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class RandomObjectGenerator {

    private static final int MIN_STRING_LENGTH = 1;
    private static final int MAX_STRING_LENGTH = 10;
    private static final int NULL_STRING_PROBABILITY = 1;

    public RandomObjectGenerator() {
    }

    public Object nextObject(Class<?> curClass) {
        Constructor<?> bestConstructor = Arrays.stream(curClass.getDeclaredConstructors())
                .reduce((x, y) -> (x.getParameterCount() > y.getParameterCount() ? x : y)).get();
        Parameter[] parameters = bestConstructor.getParameters();
        Object[] values = new Object[parameters.length];
        for (int i = 0; i < parameters.length; ++i) {
            values[i] = getRandomParameterValue(parameters[i]);
        }
        try {
            Object object = bestConstructor.newInstance(values);
            return object;
        } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public Object nextObject(Class<?> curClass, String fabricMethodName) {
        Method fabricMethod = Arrays.stream(curClass.getDeclaredMethods())
            .filter(x -> x.getName().equals(fabricMethodName))
            .findFirst().get();
        Parameter[] parameters = fabricMethod.getParameters();
        Object[] values = new Object[parameters.length];
        for (int i = 0; i < parameters.length; ++i) {
            values[i] = getRandomParameterValue(parameters[i]);
        }
        try {
            return curClass.cast(fabricMethod.invoke(null, values));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings({"ReturnCount"})
    private Object getRandomParameterValue(Parameter parameter) {
        if (parameter.getType() == int.class) {
            int min = (int) (parameter.getAnnotation(Min.class) != null
                ? parameter.getDeclaredAnnotation(Min.class).value() : Integer.MIN_VALUE);
            int max = (int) (parameter.getAnnotation(Max.class) != null
                ? parameter.getDeclaredAnnotation(Max.class).value() : Integer.MAX_VALUE);
            return ThreadLocalRandom.current().nextInt(min, max);
        } else if (parameter.getType() == long.class) {
            long min = (parameter.getAnnotation(Min.class) != null
                ? parameter.getDeclaredAnnotation(Min.class).value() : Long.MIN_VALUE);
            long max = (parameter.getAnnotation(Max.class) != null
                ? parameter.getDeclaredAnnotation(Max.class).value() : Long.MAX_VALUE);
            return ThreadLocalRandom.current().nextLong(min, max);
        } else if (parameter.getType() == double.class) {
            double min = (parameter.getAnnotation(Min.class) != null
                ? parameter.getDeclaredAnnotation(Min.class).value() : Double.MIN_VALUE);
            double max = (parameter.getAnnotation(Max.class) != null
                ? parameter.getDeclaredAnnotation(Max.class).value() : Double.MAX_VALUE);
            return ThreadLocalRandom.current().nextDouble(min, max);
        } else if (parameter.getType() == boolean.class) {
            return ThreadLocalRandom.current().nextBoolean();
        } else if (parameter.getType() == String.class) {
            if (parameter.getAnnotation(NotNull.class) == null) {
                int val = ThreadLocalRandom.current().nextInt(NULL_STRING_PROBABILITY);
                if (val == 0) {
                    return null;
                }
            }
            int stringSize = ThreadLocalRandom.current().nextInt(MIN_STRING_LENGTH, MAX_STRING_LENGTH);
            return ThreadLocalRandom.current()
                .ints('a', (int) 'z' + 1)
                .limit(stringSize)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        } else {
            Class<?> curClass = parameter.getClass();
            try {
                return curClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
