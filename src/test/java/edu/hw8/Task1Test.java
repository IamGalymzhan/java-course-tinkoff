package edu.hw8;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.Server;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Common case")
    void test() throws InterruptedException {
        startServer("localhost", 18080);
        Client client = new Client("localhost", 18080);
        assertThat(client.sendRequest("интеллект")).isEqualTo("Чем ниже интеллект, тем громче оскорбления");
    }

    void startServer(String host, int port) throws InterruptedException {
        Server server = new Server(host, port);
        Thread thread = new Thread(() -> {server.start();});
        thread.start();
        Thread.sleep(2000);
    }
}
