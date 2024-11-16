package com.nitesh.expensetracker.kafkaserviceconnect.service;


import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;


    @Autowired
    public KafkaProducerService(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishMessage(String topic,
                               KafkaMessage event) {
        log.debug("Got details {} {}", topic, event.toString());
        kafkaTemplate.send(topic, event);
    }
}
