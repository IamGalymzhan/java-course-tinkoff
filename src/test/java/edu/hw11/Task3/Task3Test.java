package edu.hw11.Task3;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.Opcodes;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {

    @Test
    void test() throws InstantiationException, IllegalAccessException, NoSuchMethodException,
        InvocationTargetException {
        Class<?> fibCalculator = new ByteBuddy()
            .subclass(Object.class)
            .name("fibCalculator")
            .defineMethod("fib", int.class, Modifier.PUBLIC).withParameters(int.class)
            .intercept(new Implementation() {
                @Override
                public ByteCodeAppender appender(Target target) {
                    return ((methodVisitor, context, methodDescription) -> {

                        Label l1 = new Label();

                        methodVisitor.visitCode();
                        // if (n < 2)
                        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
                        methodVisitor.visitInsn(Opcodes.ICONST_2);
                        methodVisitor.visitJumpInsn(Opcodes.IF_ICMPGE, l1);

                        //  return n;
                        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
                        methodVisitor.visitInsn(Opcodes.IRETURN);

                        //return getFib(n - 1) + getFib(n - 2);
                        methodVisitor.visitLabel(l1);
                        methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
                        methodVisitor.visitInsn(Opcodes.ICONST_1);
                        methodVisitor.visitInsn(Opcodes.ISUB);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fibCalculator", "fib", "(I)I");
                        methodVisitor.visitVarInsn(Opcodes.ALOAD, 0);
                        methodVisitor.visitVarInsn(Opcodes.ILOAD, 1);
                        methodVisitor.visitInsn(Opcodes.ICONST_2);
                        methodVisitor.visitInsn(Opcodes.ISUB);
                        methodVisitor.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "fibCalculator", "fib", "(I)I");
                        methodVisitor.visitInsn(Opcodes.IADD);
                        methodVisitor.visitInsn(Opcodes.IRETURN);
                        methodVisitor.visitEnd();
                        return new ByteCodeAppender.Size(5, 2);
                    });
                }

                @Override
                public InstrumentedType prepare(InstrumentedType instrumentedType) {
                    return instrumentedType;
                }
            })
            .make()
            .load(getClass().getClassLoader())
            .getLoaded();

        Method method = fibCalculator.getDeclaredMethod("fib", int.class);
        int result = (int) method.invoke(fibCalculator.getDeclaredConstructor().newInstance(),
            10);
        assertThat(result).isEqualTo(55);
    }
}
