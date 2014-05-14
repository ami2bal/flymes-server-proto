package com.mygbox.flymes.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Scanner;

/** Emission handler */
public class EmissionThread implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(EmissionThread.class);
    /** Print writer */
    private PrintWriter printWriter;
    /** Login */
    private String login = null;
    /** Message */
    private String message = null;
    /** Scanner */
    private Scanner scanner = null;

    /**
     * Constructor
     *
     * @param printWriter
     */
    public EmissionThread(PrintWriter printWriter) {
        this.printWriter = printWriter;

    }

    public void run() {

        scanner = new Scanner(System.in);

        while (true) {
            logger.info("Your message :");
            message = scanner.nextLine();
            printWriter.println(message);
            printWriter.flush();
        }
    }
}
