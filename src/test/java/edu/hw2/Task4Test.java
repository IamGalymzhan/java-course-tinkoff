package edu.hw2;

import edu.hw2.Task4.CallingInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Common case")
    void methodName() {
        CallingInfo ci = CallingInfo.callingInfo();
        assertThat(ci.methodName()).isEqualTo("methodName");
        assertThat(ci.className()).isEqualTo("edu.hw2.Task4Test");
    }
}
