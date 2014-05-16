package com.mygbox.mongo;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Date;

public class MongoLauncher {

    public static void main(String[] args) {

        try {
            MongoClient mongoClient = new MongoClient();
            DB db = mongoClient.getDB("mydb");
            DBCollection dbCollection = db.getCollection("message");
            BasicDBObject finder = new BasicDBObject("login","toto");
            DBObject dbObject = dbCollection.findOne(finder);
            System.out.println(dbObject);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
