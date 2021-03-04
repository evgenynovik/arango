package com.javaperformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.javaperformer")
public class ArangoProject {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.javaperformer");
        CrudRunner accountService = context.getBean(CrudRunner.class);
        accountService.perform();
        log.info(" Application is launched.");
    }
}
