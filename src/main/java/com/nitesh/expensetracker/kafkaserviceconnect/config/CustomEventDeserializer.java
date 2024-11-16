package com.nitesh.expensetracker.kafkaserviceconnect.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.nitesh.expensetracker.kafkaserviceconnect.model.BudgetExceededMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class CustomEventDeserializer implements Deserializer<KafkaMessage> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs,
                          boolean isKey) {
    }

    @Override
    public KafkaMessage deserialize(String topic,
                                    byte[] data) {

        try {
            String json = new String(data);
            JsonNode jsonNode = objectMapper.readTree(json);
            String type = jsonNode.get("eventType")
                    .asText();
            if ("BUDGET_EXCEEDED".equals(type)) {
                return objectMapper.treeToValue(jsonNode, BudgetExceededMessage.class);
            }

            return null; // or throw an exception for unknown types
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing event", e);
        }
    }

    @Override
    public void close() {
    }
}