package com.example.nefucc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NefuCcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NefuCcApplication.class, args);
    }

}
