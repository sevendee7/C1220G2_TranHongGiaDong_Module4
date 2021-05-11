package com.codegym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.codegym")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
