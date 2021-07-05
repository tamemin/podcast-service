package com.nime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.nime")
public class PodcastServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PodcastServiceApplication.class, args);
    }


}
