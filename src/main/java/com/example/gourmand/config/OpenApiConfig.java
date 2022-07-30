package com.example.gourmand.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gourmand API")
                        .description("Gourmand API is an application for managing your favorites recepies")
                        .version("v1")
                        .contact(new Contact()
                                .name("Mohsen Sabbaghi")
                                .url("https://www.linkedin.com/in/sabbaghi/")
                                .email("mohsen.sabbaghi@gmail.com"))
                );
    }
}
