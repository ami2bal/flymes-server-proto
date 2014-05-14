package com.mygbox.flymes.server.clienthandler;

import com.mygbox.flymes.server.datahandler.DataEmission;
import com.mygbox.flymes.server.datahandler.DataReception;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/** ClientLauncher server manager */
public class ClientServer implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ClientServer.class);
    /** Current socket */
    private Socket socket;
    /** Buffered reader */
    private BufferedReader bufferedReader;
    /** Print writer */
    private PrintWriter printWriter;
    /** Login */
    private String login;
    /** Thread reception */
    private Thread threadIn;
    /** Thread emission */
    private Thread threadOut;

    /**
     * Constructor
     *
     * @param socket
     * @param login
     */
    public ClientServer(Socket socket, String login) {
        this.socket = socket;
        this.login = login;
    }

    @Override
    public void run() {

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());

            threadIn = new Thread(new DataReception(bufferedReader, login));
            threadIn.start();
            threadOut = new Thread(new DataEmission(printWriter));
            threadOut.start();
        } catch (Exception e) {
            logger.info("{} is logout", login);
        }
    }
}
