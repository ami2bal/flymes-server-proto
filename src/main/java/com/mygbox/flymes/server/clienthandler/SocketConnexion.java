package com.mygbox.flymes.server.clienthandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.ServerSocket;
import java.net.Socket;

/** Connection manager */
public class SocketConnexion implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ClientServer.class);
    /** Current thread */
    public Thread thread;
    /** Socket server */
    private ServerSocket serverSocket;
    /** Current socket */
    private Socket socket;

    /**
     * Constructor
     *
     * @param serverSocket
     */
    public SocketConnexion(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                socket = serverSocket.accept();
                logger.info("Someone is connecting");
                thread = new Thread(new Authentification(socket));
                thread.start();
            }
        } catch (Exception e) {
            logger.info("Impossible to connect new user", e);
        }
    }
}
