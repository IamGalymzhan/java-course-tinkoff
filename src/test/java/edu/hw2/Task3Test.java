package edu.hw2;

import edu.hw2.Task3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Faulty Connection Manager")
    void faultManager() {
        FaultyConnectionManager fcm = new FaultyConnectionManager();
        Connection connection = fcm.getConnection();

        assertThat(connection.getClass().toString()).isEqualTo("class edu.hw2.Task3.FaultyConnection");
    }

    @Test
    @DisplayName("Default Connection Manager")
    void defaultManager() {
        DefaultConnectionManager dcm = new DefaultConnectionManager();
        Connection connection = dcm.getConnection();

        assertThat(connection.getClass().toString()).isIn(
            "class edu.hw2.Task3.FaultyConnection", "class edu.hw2.Task3.StableConnection");
    }
}
