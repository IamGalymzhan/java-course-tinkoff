package edu.hw2.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {
    private final static Logger LOGGER = LogManager.getLogger();
    private final ConnectionManager manager = new DefaultConnectionManager();
    private final int maxAttempts = 5;

    public void updatePackages() {
        try {
            tryExecute("apt update && apt upgrade -y");
        } catch (Exception e) {
            LOGGER.info("Couldn't execute command");
        }
    }

    private void tryExecute(String command) throws ConnectionException {
        for (int i = 0; i < maxAttempts; i++) {
            Connection connection = null;
            try {
                connection = manager.getConnection();
                connection.execute(command);
                return;
            } catch (Exception e) {
                LOGGER.info("Connection failed");
            } finally {
                try {
                    connection.close();
                } catch (Exception e) {
                    LOGGER.info("Cannot close connection");
                }
            }
        }
        throw new ConnectionException();
    }
}
