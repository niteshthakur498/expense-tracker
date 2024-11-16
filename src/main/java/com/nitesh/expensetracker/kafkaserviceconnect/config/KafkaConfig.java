package com.nitesh.expensetracker.kafkaserviceconnect.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put("bootstrap.servers", bootstrapServers); // Update with your Kafka broker address
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic budgetExceededTopic() {
        return TopicBuilder.name("budget-exceeded")
                .partitions(1) // Number of partitions
                .replicas(1)    // Replication factor
                .build();
    }
}