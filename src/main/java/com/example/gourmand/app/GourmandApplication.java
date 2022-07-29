package com.example.gourmand.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@PropertySource("classpath:application-${spring.profiles.active}.properties")
public class GourmandApplication {

    public static void main(String[] args) {
        SpringApplication.run(GourmandApplication.class, args);
    }
}
