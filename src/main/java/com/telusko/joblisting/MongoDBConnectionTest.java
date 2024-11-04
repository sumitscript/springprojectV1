package com.telusko.joblisting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class MongoDBConnectionTest implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("\n-------------------------------");
            System.out.println("MongoDB Connection Test");
            System.out.println("-------------------------------");
            System.out.println("MongoDB Database Name: " + mongoTemplate.getDb().getName());
            System.out.println("MongoDB Connection Successful!");
            
            // List all collections
            System.out.println("\nAvailable Collections:");
            mongoTemplate.getDb().listCollectionNames()
                .forEach(System.out::println);
            System.out.println("-------------------------------\n");
                
        } catch (Exception e) {
            System.err.println("\n-------------------------------");
            System.err.println("MongoDB Connection Failed!");
            System.err.println("Error: " + e.getMessage());
            System.err.println("-------------------------------\n");
            e.printStackTrace();
        }
    }
}