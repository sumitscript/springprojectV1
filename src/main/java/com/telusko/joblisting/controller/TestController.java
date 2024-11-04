package com.telusko.joblisting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.joblisting.model.Post;

@RestController
public class TestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/test-db")
    public String testConnection() {
        try {
            String dbName = mongoTemplate.getDb().getName();
            return "MongoDB Connection Success! Connected to Database: " + dbName;
        } catch (Exception e) {
            return "Connection Failed: " + e.getMessage();
        }
    }

@GetMapping("/test-insert")
public String testInsert() {
    try {
        // Create test post
        Post post = new Post();
        post.setProfile("Test Job");
        post.setDesc("This is a test job posting");
        post.setExp(2);
        post.setTechs(new String[]{"Java", "Spring"});

        // Save to database
        Post savedPost = mongoTemplate.save(post, "JobPost");
        
        return "Test data inserted successfully! Post: " + savedPost.toString();
    } catch (Exception e) {
        return "Failed to insert test data: " + e.getMessage();
    }
}}