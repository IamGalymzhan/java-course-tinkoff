package edu.hw8.Task1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Server {
    private InetSocketAddress address;
    private WorkerHandler workerHandler;

    public Server(String host, int port) {
        this.address = new InetSocketAddress(host, port);
        this.workerHandler = new WorkerHandler();
    }

    public void start() {
        try (Selector selector = Selector.open()) {
            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(this.address);
            channel.register(selector, SelectionKey.OP_ACCEPT);
            while (channel.isOpen()) {
                selector.select();
                var keys = selector.keys();
                for (var key : keys) {
                    if (key.isAcceptable()) {
                        startWorker(channel.accept());
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void startWorker(SocketChannel client) {
        workerHandler.handleClient(client);
    }
}
