package edu.hw2.Task3;

public class DefaultConnectionManager implements ConnectionManager {

    private static final double FAULTY_CONNECTION_PROBABILITY = 0.3;

    @Override
    public Connection getConnection() {
        if (Math.random() <= FAULTY_CONNECTION_PROBABILITY) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
