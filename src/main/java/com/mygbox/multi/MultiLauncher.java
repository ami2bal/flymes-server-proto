package com.mygbox.multi;

/**
 * Created with IntelliJ IDEA.
 * User: vav6wy
 * Date: 14/05/14
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class MultiLauncher {

    public static void main(String[] args) {
        MultiThreadedServer server = new MultiThreadedServer(9000);
        new Thread(server).start();

        try {
            Thread.sleep(60* 10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping Server");
        server.stop();
    }
}
