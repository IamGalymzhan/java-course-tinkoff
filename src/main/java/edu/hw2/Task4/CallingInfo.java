package edu.hw2.Task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        StackTraceElement[] ste = new Throwable().getStackTrace();
        return new CallingInfo(ste[1].getClassName(), ste[1].getMethodName());
    }
}
