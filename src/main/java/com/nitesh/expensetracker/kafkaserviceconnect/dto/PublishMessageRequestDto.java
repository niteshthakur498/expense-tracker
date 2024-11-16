package com.nitesh.expensetracker.kafkaserviceconnect.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nitesh.expensetracker.kafkaserviceconnect.config.KafkaMessageDeserializer;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublishMessageRequestDto {

    //@NotBlank(message = "")
    @JsonProperty("topic-name")
    String topicName;

    //@NotBlank(message = "")
    @JsonProperty("message")
    @JsonDeserialize(using = KafkaMessageDeserializer.class)
    KafkaMessage message;

}
