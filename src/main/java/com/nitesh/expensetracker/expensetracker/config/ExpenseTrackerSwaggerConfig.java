package com.nitesh.expensetracker.expensetracker.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExpenseTrackerSwaggerConfig {
    @Bean
    public GroupedOpenApi expenseApi() {
        return GroupedOpenApi.builder()
                .group("Expense Tracker API")
                .packagesToScan("com.nitesh.expensetracker.expensetracker") // Change to your Expense Tracker package
                .build();
    }
}
