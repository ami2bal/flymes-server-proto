package com.mygbox.vertx;

import org.vertx.java.core.AsyncResult;
import org.vertx.java.core.AsyncResultHandler;
import org.vertx.java.core.net.NetClient;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.platform.Verticle;

/**
 * Created with IntelliJ IDEA.
 * User: vav6wy
 * Date: 15/05/14
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class ClientVertx extends Verticle {

    public void start() {
        NetClient client = vertx.createNetClient();

        client.connect(1234, "localhost", new AsyncResultHandler<NetSocket>() {
            public void handle(AsyncResult<NetSocket> asyncResult) {
                if (asyncResult.succeeded()) {
                    System.out.println("We have connected! Socket is " + asyncResult.result());
                } else {
                    asyncResult.cause().printStackTrace();
                }
            }
        });
    }
}
