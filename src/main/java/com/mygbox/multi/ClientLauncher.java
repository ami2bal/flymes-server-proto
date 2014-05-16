package com.mygbox.multi;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vav6wy
 * Date: 14/05/14
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class ClientLauncher {

    public static int i = 0;

    public static void main(String[] args) {
        List<Socket> socketList = new ArrayList();
        try {
            for (int i = 0; i < 10000000; i++) {
                /*System.out.println(i);
                URL url = new URL("http://localhost:9000/");
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));*/

                Socket socket = new Socket("127.0.0.1", 9000);
                socketList.add(socket);

                i++;
                System.out.println("Connected : " + i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            for (Socket socket : socketList) {
                if (null != socket) {
                    try {
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
