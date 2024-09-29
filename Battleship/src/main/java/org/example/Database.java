package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.Arrays;

public class Database {
    private static String uri = "mongodb+srv://iven0202:OISCtT0MMpopGAK3@leaderboard.iwjnk.mongodb.net/?retryWrites=true&w=majority&appName=leaderboard";
    private static MongoClient mongoClient = MongoClients.create(uri);
    private static MongoDatabase database = mongoClient.getDatabase("leaderboard");
    private static MongoCollection<Document> collection = database.getCollection("Users and Scores");
    private static Bson filter;

    public static void printEasyLeaderboard (){
        filter = Filters.eq("Difficulty","Easy");
        collection.find(filter).forEach(doc -> System.out.println(doc.toJson()));
    }
    public static void printMediumLeaderboard (){
        filter = Filters.eq("Difficulty","Medium");
        collection.find(filter).forEach(doc -> System.out.println(doc.toJson()));
    }

    public static void printHardLeaderboard (){
        filter = Filters.eq("Difficulty","Hard");
        collection.find(filter).forEach(doc -> System.out.println(doc.toJson()));
    }

    public static void insert(String user, int score, double hitRate, String difficulty){
        collection.insertOne(new Document()
                .append("_id", new ObjectId())
                .append("User", user)
                .append("Score", score)
                .append("Hit Rate", hitRate)
                .append("Difficulty", difficulty));
    }

}
