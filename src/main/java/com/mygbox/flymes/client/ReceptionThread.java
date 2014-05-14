package com.mygbox.flymes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

/** Reception handler */
public class ReceptionThread implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(ReceptionThread.class);
    /** Buffered reader */
    private BufferedReader bufferedReader;
    /** Message */
    private String message = null;

    /**
     * Constructor
     *
     * @param bufferedReader
     */
    public ReceptionThread(BufferedReader bufferedReader) {

        this.bufferedReader = bufferedReader;
    }

    public void run() {

        while (true) {
            try {

                message = bufferedReader.readLine();
                logger.info("Server says : {}", message);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }

}
