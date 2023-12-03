package edu.hw8.Task1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class WorkerHandler {
    private static final Map<String, String> RESPONSES = Map.of(
        "личности", "Не переходи на личности там, где их нет",
        "оскорбления", "Если твои противники перешли на личные оскорбления, будь уверена — твоя победа не за горами",
        "глупый", "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "интеллект", "Чем ниже интеллект, тем громче оскорбления"
    );

    private static final int THREAD_COUNT = 4;
    private static final int MAX_CONNECTIONS = 4;
    private static final int BUFFER_SIZE = 1024;
    private Semaphore semaphore = new Semaphore(MAX_CONNECTIONS);
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    public WorkerHandler() {
    }

    public void handleClient(SocketChannel client) {
        executor.submit(() -> {
            run(client);
        });
    }

    private void run(SocketChannel client) {
        try (Selector selector = Selector.open()) {
            semaphore.acquire();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
            while (client.isOpen()) {
                selector.select();
                var keys = selector.keys();
                for (var key : keys) {
                    if (key.isReadable()) {
                        String request = readRequest(client);
                        sendResponse(client, request);
                        client.close();
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    private String readRequest(SocketChannel client) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        int bytesRead = client.read(buffer);
        if (bytesRead != -1) {
            String request = new String(buffer.array(), StandardCharsets.UTF_8);
            return request.trim();
        }
        return "";
    }

    private void sendResponse(SocketChannel client, String request) throws IOException {
        String response = RESPONSES.getOrDefault(request, "Default");
        ByteBuffer buffer = ByteBuffer.wrap(response.getBytes(StandardCharsets.UTF_8));
        while (buffer.hasRemaining()) {
            client.write(buffer);
        }
    }
}
