package com.mygbox.flymes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/** Connection handler */
public class Connection implements Runnable {
    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(Connection.class);
    /** Current thread */
    public static Thread thread;
    /** Login */
    public static String login = null;
    /** Password */
    public static String password = null;
    /** Socket */
    private Socket socket = null;
    /** Print writer */
    private PrintWriter printWriter = null;
    /** Buffered reader */
    private BufferedReader bufferedReader = null;
    /** Scanner */
    private Scanner scanner = null;
    /** Connection state */
    private boolean isConnected = false;

    /**
     * Constructor
     *
     * @param s
     */
    public Connection(Socket s) {

        socket = s;
    }

    public void run() {

        try {

            printWriter = new PrintWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            scanner = new Scanner(System.in);


            while (!isConnected) {

                logger.info(bufferedReader.readLine());
                login = scanner.nextLine();
                printWriter.println(login);
                printWriter.flush();

                logger.info(bufferedReader.readLine());
                password = scanner.nextLine();
                printWriter.println(password);
                printWriter.flush();

                if (bufferedReader.readLine().equals("connected")) {

                    logger.info("I am connected");
                    isConnected = true;
                } else {
                    logger.error("Your informations are wrong");
                }

            }

            thread = new Thread(new ClientServer(socket));
            thread.start();

        } catch (IOException e) {

            logger.error("Server doesn't respond anymore");
        }
    }
}
