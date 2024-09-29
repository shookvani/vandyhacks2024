
package com.test.testOne;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.concurrent.atomic.AtomicInteger;

import static com.mongodb.client.model.Sorts.descending;

public class Database {
    private static String uri = "mongodb+srv://iven0202:OISCtT0MMpopGAK3@leaderboard.iwjnk.mongodb.net/?retryWrites=true&w=majority&appName=leaderboard";
    private static MongoClient mongoClient = MongoClients.create(uri);
    private static MongoDatabase database = mongoClient.getDatabase("leaderboard");
    private static MongoCollection<Document> collection = database.getCollection("Users and Scores");
    private static Bson filter;

    public static void printEasyLeaderboard () {
        int count = 1;
        filter = Filters.eq("Difficulty", "Easy");
        Bson projection = Projections.fields(Projections.include("User", "Score", "Hit Rate", "Difficulty"), Projections.excludeId());
        //Iteration code inspired by Piotr Wilkin on Stack Overflow
        FindIterable<Document> documentCursor = collection.find(filter).sort(descending("Score")).projection(projection);
        for (Document doc : documentCursor) {
            System.out.println(count + ". " + doc.getString("User") + " - " + doc.getInteger("Score") + " - " + doc.getDouble("Hit Rate") + "%");
            count++;
            if (count == 11) {
                break;
            }
        }
    }

    public static void printMediumLeaderboard (){
        int count = 1;
        filter = Filters.eq("Difficulty","Medium");
        Bson projection = Projections.fields(Projections.include("User","Score","Hit Rate", "Difficulty"), Projections.excludeId());
        //Iteration code inspired by Piotr Wilkin on Stack Overflow
        FindIterable<Document> documentCursor = collection.find(filter).sort(descending("Score")).projection(projection);
        for (Document doc: documentCursor){
            System.out.println(count + ". " + doc.getString("User") + " - " + doc.getInteger("Score") + " - " + doc.getDouble("Hit Rate") + "%");
            count++;
            if (count == 11){
                break;
            }
        }
    }

    public static void printHardLeaderboard (){
        int count = 1;
        filter = Filters.eq("Difficulty","Hard");
        Bson projection = Projections.fields(Projections.include("User","Score","Hit Rate", "Difficulty"), Projections.excludeId());
        //Iteration code inspired by Piotr Wilkin on Stack Overflow
        FindIterable<Document> documentCursor = collection.find(filter).sort(descending("Score")).projection(projection);
        for (Document doc: documentCursor){
            System.out.println(count + ". " + doc.getString("User") + " - " + doc.getInteger("Score") + " - " + doc.getDouble("Hit Rate") + "%");
            count++;
            if (count == 11){
                break;
            }
        }
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