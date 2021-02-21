package com.javaperformer.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.javaperformer")
public class ArangoProject {
    public static void main(String[] args) {
        CrudRunner starter = new AnnotationConfigApplicationContext(ArangoProject.class).getBean(CrudRunner.class);
//        CrudRunner starter = ctx.getBean(CrudRunner.class);
        starter.perform();
    }
}
