package com.javaperformer.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = "com.javaperformer")
public class ArangoProject {
    public static void main(String[] args) {
        SpringApplication.run(ArangoProject.class, args);
        log.info(" Application is launched.");
    }
}
