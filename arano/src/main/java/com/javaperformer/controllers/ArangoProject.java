package com.javaperformer.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.javaperformer")
public class ArangoProject {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(ArangoProject.class);
        CrudRunner starter = ctx.getBean(CrudRunner.class);
        starter.perform();
    }
}
