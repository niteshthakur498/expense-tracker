package com.nitesh.expensetracker.securitymanagement.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthSwaggerConfig {
    @Bean
    public GroupedOpenApi authApi() {
        return GroupedOpenApi.builder()
                .group("Auth API")
                .packagesToScan("com.nitesh.expensetracker.securitymanagement") // Change to your Auth package
                .build();
    }
}
