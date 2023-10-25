package edu.hw2.Task1;

public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {
        public double evaluate() {
            return -value.evaluate();
        }
    }

    public record Exponent(Expr value1, double value2) implements Expr {
        public double evaluate() {
            return Math.pow(value1.evaluate(), value2);
        }
    }

    public record Addition(Expr value1, Expr value2) implements Expr {
        public double evaluate() {
            return value1.evaluate() + value2.evaluate();
        }
    }

    public record Multiplication(Expr value1, Expr value2) implements Expr {
        public double evaluate() {
            return value1.evaluate() * value2.evaluate();
        }
    }
}
