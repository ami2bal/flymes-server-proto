package com.mygbox.flymes.server.datahandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Scanner;

/** Server data communication */
public class DataEmission implements Runnable {

    /** Logger */
    private static final Logger logger = LoggerFactory.getLogger(DataEmission.class);
    /** Print writer */
    private PrintWriter printWriter;
    /** Message */
    private String message = null;
    /** Scanner */
    private Scanner scanner = null;

    /**
     * Constructor
     *
     * @param printWriter
     */
    public DataEmission(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    @Override
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
