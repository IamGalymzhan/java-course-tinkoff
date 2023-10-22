package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final static Logger LOGGER = LogManager.getLogger();

    private static final double FAULT_PROBABILITY = 0.5;

    @Override
    public void execute(String command) throws ConnectionException {
        if (Math.random() <= FAULT_PROBABILITY) {
            throw new ConnectionException();
        }
        LOGGER.info("Executed command: " + command);
    }

    @Override
    public void close() throws Exception {
        LOGGER.info("Connection closed");
    }
}
