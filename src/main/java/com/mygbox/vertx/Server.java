package com.mygbox.vertx;

import org.vertx.java.core.Handler;
import org.vertx.java.core.net.NetServer;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.platform.Verticle;

public class Server extends Verticle {

    public void start() {
        NetServer server = vertx.createNetServer();

        server.connectHandler(new Handler<NetSocket>() {
            public void handle(NetSocket sock) {
                System.out.println("A client has connected!");
            }
        }).listen(1234, "localhost");
    }
}