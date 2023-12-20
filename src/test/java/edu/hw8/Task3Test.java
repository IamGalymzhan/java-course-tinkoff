package edu.hw8;

import edu.hw8.Task3.Hack;
import edu.hw8.Task3.MultiThreadHack;
import edu.hw8.Task3.OneThreadHack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("One Thread Hack")
    void oneThreadTest() {
        Hack hack = new OneThreadHack();
        Map<String, String> hashUser = Map.of(
            OneThreadHack.hash("pass"), "alex",
            OneThreadHack.hash("o1o1s"), "steve"
        );

        Map<String, String> result = hack.hack(hashUser);

        assertThat(result).containsAllEntriesOf(Map.of(
            "pass", "alex",
            "o1o1s", "steve"
        ));
    }

    @Test
    @DisplayName("Multi Thread Hack")
    void multiThreadTest() {
        Hack hack = new MultiThreadHack();
        Map<String, String> hashUser = Map.of(
            MultiThreadHack.hash("pass"), "alex",
            MultiThreadHack.hash("o1o1s"), "steve"
        );

        Map<String, String> result = hack.hack(hashUser);

        assertThat(result).containsAllEntriesOf(Map.of(
            "pass", "alex",
            "o1o1s", "steve"
        ));
    }
}
