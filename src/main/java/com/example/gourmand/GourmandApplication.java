package com.example.gourmand;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(title = "Gourmand API", version = "v1", description = "Recipe API designed to manage your favourite recipes. this app ables you to do CRUD operations on recipes that you were created."),
        tags = {
                @Tag(name = "recipes", description = "initiate a communication, get details of communication, update status of communication, listing and querying communications")
        }
)
@SpringBootApplication
public class GourmandApplication {
    public static void main(String[] args) {
        SpringApplication.run(GourmandApplication.class, args);
    }
}
