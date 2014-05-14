package com.mygbox.flymes.server.clienthandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** ClientLauncher socket authentification authentification */
public class Authentification implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(Authentification.class);
    /** Current socket */
    private Socket socket;
    /** Print writer */
    private PrintWriter printWriter;
    /** Buffered reader */
    private BufferedReader bufferedReader;
    /** Current login */
    private String login = "John";
    /** Current password */
    private String password = null;
    /** Authentification Activated */
    private boolean isAuthentified = false;
    /** Current thread */
    private Thread thread;

    /**
     * Constructor
     *
     * @param socket
     */
    public Authentification(Socket socket) {
        this.socket = socket;
    }

    /**
     * Check if the login/password couple is valid
     *
     * @param login
     * @param password
     *
     * @return
     */
    private static boolean isValid(String login, String password) {

        boolean connexion = true;
        try {

        } catch (Exception e) {
            logger.info("{} tried to connect", login, e);
        }
        return connexion;
    }

    @Override
    public void run() {

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());

            while (!isAuthentified) {

                printWriter.println("Please enter your login :");
                printWriter.flush();
                login = bufferedReader.readLine();

                printWriter.println("Please enter your password :");
                printWriter.flush();
                password = bufferedReader.readLine();

                if (isValid(login, password)) {
                    printWriter.println("connected");
                    logger.info("{} is connected",login);
                    printWriter.flush();
                    isAuthentified = true;
                } else {
                    printWriter.println("Connection error");
                    printWriter.flush();
                }

                thread = new Thread(new                                                                                                                                                                         ClientServer(socket, login));
                thread.start();
            }

        } catch (Exception e) {
            logger.info("Error during client connection", e);
        }
    }
}
