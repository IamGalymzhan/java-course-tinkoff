package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static net.bytebuddy.matcher.ElementMatchers.returns;
import static net.bytebuddy.matcher.ElementMatchers.takesArguments;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {

    @Test
    void test() throws IllegalAccessException, NoSuchMethodException,
        InvocationTargetException, InstantiationException {

        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ArithmeticUtils.class)
            .method(named("sum"))
            .intercept(MethodDelegation.to(Target.class))
            .make()
            .load(ClassLoader.getSystemClassLoader(), ClassReloadingStrategy.fromInstalledAgent())
            .getLoaded();

        assertThat(ArithmeticUtils.sum(4, 3)).isEqualTo(12);
    }
}
