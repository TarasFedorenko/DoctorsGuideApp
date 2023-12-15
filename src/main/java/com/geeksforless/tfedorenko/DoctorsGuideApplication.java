package com.geeksforless.tfedorenko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication

public class DoctorsGuideApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorsGuideApplication.class, args);
    }
}