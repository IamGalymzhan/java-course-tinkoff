package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class Client {
    private static final int BUFFER_SIZE = 1024;

    private InetSocketAddress address;

    public Client(String host, int port) {
        this.address = new InetSocketAddress(host, port);
    }

    public String sendRequest(String request) {
        try (SocketChannel socketChannel = SocketChannel.open(address)) {
            ByteBuffer buffer = ByteBuffer.wrap(request.getBytes(StandardCharsets.UTF_8));
            while (buffer.hasRemaining()) {
                socketChannel.write(buffer);
            }
            buffer.flip();
            buffer = ByteBuffer.allocate(BUFFER_SIZE);
            int bytesRead = socketChannel.read(buffer);
            String response = "";
            while (bytesRead == 0) {
                bytesRead = socketChannel.read(buffer);
            }
            if (bytesRead != -1) {
                response = new String(buffer.array(), StandardCharsets.UTF_8);
            }
            return response.trim();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
