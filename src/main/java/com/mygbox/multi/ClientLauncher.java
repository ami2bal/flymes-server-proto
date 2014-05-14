package com.mygbox.multi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: vav6wy
 * Date: 14/05/14
 * Time: 10:18
 * To change this template use File | Settings | File Templates.
 */
public class ClientLauncher {

    public static void main(String[] args) {
        try {
            for(int i = 0 ; i < 10000000 ; i++){
                System.out.println(i);
                URL url = new URL("http://localhost:9000/");
                URLConnection urlConnection = url.openConnection();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
