package com.javaperformer.controllers;

import com.arangodb.ArangoCollection;
import com.arangodb.ArangoCursor;
import com.arangodb.ArangoDB;
import com.arangodb.ArangoDBException;
import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.model.AqlQueryOptions;
import com.arangodb.util.MapBuilder;
import com.arangodb.velocypack.VPackSlice;
import com.arangodb.velocypack.exception.VPackException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.javaperformer")
public class ArangoProject {
//    static class MyConfiguration implements ArangoConfiguration{
//    }
    public static void main(String[] args) {
//        SpringApplication.run(ArangoProject.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.javaperformer");
        CrudRunner starter = ctx.getBean(CrudRunner.class);
        starter.perform();
//        ArangoDB arangoDB = new ArangoDB.Builder()
//                .host("192.168.99.100")
//                .user("root")
//                .password("password").build();
//        final String dbName = "mydb";
//        try {
//            arangoDB.createDatabase(dbName);
//            System.out.println("Database created: " + dbName);
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to create database: " + dbName + "; " + e.getMessage());
//        }
//        String collectionName = "firstCollection";
//        try {
//            CollectionEntity myArangoCollection = arangoDB.db(dbName).createCollection(collectionName);
//            System.out.println("Collection created: " + myArangoCollection.getName());
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to create collection: " + collectionName + "; " + e.getMessage());
//        }
//        BaseDocument myObject = new BaseDocument();
//        myObject.setKey("myKey");
//        myObject.addAttribute("a", "Foo");
//        myObject.addAttribute("b", 42);
//        try {
//            arangoDB.db(dbName).collection(collectionName).insertDocument(myObject);
//            System.out.println("Document created");
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to create document. " + e.getMessage());
//        }
//        try {
//            BaseDocument myDocument = arangoDB.db(dbName).collection(collectionName).getDocument("myKey",
//                    BaseDocument.class);
//            System.out.println("Key: " + myDocument.getKey());
//            System.out.println("Attribute a: " + myDocument.getAttribute("a"));
//            System.out.println("Attribute b: " + myDocument.getAttribute("b"));
//        } catch (ArangoDBException e) {
//            System.err.println("Failed to get document: myKey; " + e.getMessage());
//        }
    }
}
