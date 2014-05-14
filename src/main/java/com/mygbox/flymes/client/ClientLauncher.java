package com.mygbox.flymes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/** Client launcher */
public class ClientLauncher {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ClientLauncher.class);
    /** Socket */
    public static Socket socket = null;
    /** Thread */
    public static Thread thread;

    /**
     * Launcher method
     *
     * @param args
     */
    public static void main(String[] args) {


        try {

            logger.info("Connection asking");
            socket = new Socket("127.0.0.1", 2009);
            logger.info("Connection enabled, authentification :");

            thread = new Thread(new Connection(socket));
            thread.start();


        } catch (UnknownHostException e) {
            logger.error("Impossible to connect on the adress : {}", socket.getLocalAddress());
        } catch (IOException e) {
            logger.error("No server is listening on port : {}", socket.getLocalPort());
        }


    }
}
