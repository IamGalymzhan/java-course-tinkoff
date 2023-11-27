package edu.hw6.Task6;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortScanner {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final Map<Integer, String> PORT_SERVICE = Map.of(
        80, "HTTP",
        21, "FTP",
        25, "SMTP",
        22, "SSH",
        443, "HTTPS",
        53, "DNS",
        3306, "MySQL Database",
        5432, "PostgreSQL Database",
        3389, "Remote Desktop Protocol (RDP)",
        27017, "MongoDB Database"
    );
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;

    private PortScanner() {
    }

    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) {
        LOGGER.info("Protocol\tPort\tService");
        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                // Try TCP port
            } catch (IOException e) {
                LOGGER.info("TCP\t\t\t" + port + "\t"
                    + (PORT_SERVICE.containsKey(port) ? PORT_SERVICE.get(port) : ""));
            }
            try (DatagramSocket datagramSocket = new DatagramSocket(port)) {
                // Try UDP port
            } catch (IOException e) {
                LOGGER.info("UDP\t\t\t" + port + "\t"
                    + (PORT_SERVICE.containsKey(port) ? PORT_SERVICE.get(port) : ""));
            }
        }
    }
}
