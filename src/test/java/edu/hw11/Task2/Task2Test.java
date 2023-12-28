package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.dynamic.ClassFileLocator;
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

    /*

    @Test
    void test() throws IllegalAccessException, NoSuchMethodException,
        InvocationTargetException, InstantiationException {

        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(ArithUtils.class)
            .method(named("sum")
                .and(returns(int.class))
                .and(isDeclaredBy(ArithUtils.class)))
            .intercept(MethodDelegation.to(ChangedArithUtils.class))
            .make()
            .load(ArithUtils.class.getClassLoader(),
                ClassReloadingStrategy.fromInstalledAgent())
            .getLoaded();

        ArithUtils arithmeticUtils = new ArithUtils();

        assertThat(arithmeticUtils.sum(4, 3)).isEqualTo(12);
    }

    */
}
