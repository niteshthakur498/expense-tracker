package com.nitesh.expensetracker.kafkaserviceconnect.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitesh.expensetracker.kafkaserviceconnect.model.BudgetExceededMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class KafkaMessageDeserializer extends JsonDeserializer<KafkaMessage> {

    @Override
    public KafkaMessage deserialize(JsonParser p,
                                    DeserializationContext context) throws IOException {
        ObjectMapper mapper = (ObjectMapper) p.getCodec();
        JsonNode node = mapper.readTree(p);

        log.debug("Deserializing KafkaMessage node: {}", node.toString());

        String type = node.get("eventType")
                .asText();
        log.debug("Event type found: {}", type);

        if ("BUDGET_EXCEEDED".equals(type)) {
            // Deserialize directly into the concrete class BudgetExceededMessage
            BudgetExceededMessage message = mapper.treeToValue(node, BudgetExceededMessage.class);
            log.debug("message found: {}", message);
            return message;
        }

        // If no match, throw an exception or handle it accordingly
        throw new IOException("Unknown type: " + type);
    }
}
