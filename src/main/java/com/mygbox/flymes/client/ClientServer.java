package com.mygbox.flymes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/** Client Server Manager */
public class ClientServer implements Runnable {
    /** Socket */
    private Socket socket;
    /** Print writer */
    private PrintWriter printWriter;
    /** Buffered reader */
    private BufferedReader bufferedReader;
    /** Scanner */
    private Scanner scanner;
    /** Reception Thread */
    private Thread threadIn;
    /** Emission Thread */
    private Thread threadOut;
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ClientServer.class);

    /**
     * Constructor
     *
     * @param socket
     */
    public ClientServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            printWriter = new PrintWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            scanner = new Scanner(System.in);

            threadIn = new Thread(new EmissionThread(printWriter));
            threadIn.start();
            threadOut = new Thread(new ReceptionThread(bufferedReader));
            threadOut.start();
        } catch (Exception e) {
            logger.info("The server stopped the connection");
        }
    }
}
