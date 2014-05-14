package com.mygbox.flymes.server;

import com.mygbox.flymes.server.clienthandler.SocketConnexion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

/** Server manager */
public class ServerLauncher {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ServerLauncher.class);
    /** Server socket */
    public static ServerSocket serverSocket;
    /** Thread */
    public static Thread thread;

    /**
     * Launcher
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            serverSocket = new ServerSocket(2009);
            logger.info("The server is listening on port : {}", serverSocket.getLocalPort());

            thread = new Thread(new SocketConnexion(serverSocket));
            thread.start();
        } catch (IOException e) {
            logger.info("The port {} is already used", serverSocket.getLocalPort());
        }
    }
}
