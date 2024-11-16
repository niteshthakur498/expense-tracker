package com.nitesh.expensetracker.kafkaserviceconnect.controller;

import com.nitesh.expensetracker.kafkaserviceconnect.dto.PublishMessageRequestDto;
import com.nitesh.expensetracker.kafkaserviceconnect.model.KafkaMessage;
import com.nitesh.expensetracker.kafkaserviceconnect.service.KafkaProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/message-stream")
@Slf4j
public class EventController {
    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public EventController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/publish-message")
    public ResponseEntity<String> publishBudgetExceededEvent(@RequestBody PublishMessageRequestDto messageRequest) {
        log.debug("Entered publishBudgetExceededEvent....{}", messageRequest.toString());
        kafkaProducerService.publishMessage(messageRequest.getTopicName(), messageRequest.getMessage());
        log.debug("Returning publishBudgetExceededEvent....");
        return ResponseEntity.ok("Message Published Successfully");
    }
}
