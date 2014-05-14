package com.mygbox.flymes.server.datahandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;

/** Data reception manager */
public class DataReception implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(DataReception.class);
    /** Buffered reader */
    private BufferedReader bufferedReader;
    /** Current message */
    private String message;
    /** Current login */
    private String login;

    /**
     * Constructor
     *
     * @param bufferedReader
     * @param login
     */
    public DataReception(BufferedReader bufferedReader, String login) {
        this.bufferedReader = bufferedReader;
        this.login = login;
    }

    @Override
    public void run() {
        while (true) {
            try {
                message = bufferedReader.readLine();
                logger.info("{} said : {}", login, message);
            } catch (Exception e) {
                logger.error("Impossible to read data from clients", e);
            }
        }
    }
}
