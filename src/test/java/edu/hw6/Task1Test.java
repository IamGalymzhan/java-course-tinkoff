package edu.hw6;

import edu.hw6.Task1.DiskMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Test 1")
    void test1() {
        try (DiskMap diskMap = new DiskMap()) {
            assertThat(diskMap.put("k1", "v1")).isNull();
            assertThat(diskMap.size()).isEqualTo(1);
            assertThat(diskMap.isEmpty()).isFalse();
            assertThat(diskMap.containsKey("k1")).isTrue();
            assertThat(diskMap.containsKey("k2")).isFalse();
            assertThat(diskMap.containsValue("v1")).isTrue();
            assertThat(diskMap.containsValue("v2")).isFalse();
            assertThat(diskMap.get("k1")).isEqualTo("v1");
            assertThat(diskMap.put("k1", "v2")).isEqualTo("v1");
        }
    }

    @Test
    @DisplayName("Test 2")
    void test2() {
        try (DiskMap diskMap = new DiskMap()) {
            diskMap.put("k1", "v1");
            assertThat(diskMap.remove("k1")).isEqualTo("v1");
            assertThat(diskMap.get("k1")).isNull();
            diskMap.putAll(
                Map.of("k1", "v1", "k2", "v2")
            );
            assertThat(diskMap.entrySet()).isEqualTo(
                Set.of(
                    Map.entry("k1", "v1"),
                    Map.entry("k2", "v2")
                )
            );
            assertThat(diskMap.keySet()).isEqualTo(
                Set.of("k1", "k2")
            );
            assertThat(diskMap.values()).isEqualTo(
                Set.of("v1", "v2")
            );
            diskMap.clear();
            assertThat(diskMap.isEmpty()).isTrue();

        }
    }
}
