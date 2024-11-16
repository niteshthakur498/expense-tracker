package com.nitesh.expensetracker.kafkaserviceconnect.util;

import com.nitesh.expensetracker.core.util.RestTemplateClientUtility;
import com.nitesh.expensetracker.kafkaserviceconnect.dto.PublishMessageRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaServiceClientUtility {

    @Value("${kafka.publish-message.service-url}")
    private String publishApiUrl;

    public ResponseEntity<String> publishMessage(PublishMessageRequestDto publishMessageRequest) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        httpHeaders.add("Accept", "application/json");
        HttpMethod method = HttpMethod.POST;
        log.debug("Making API call to publish message..{}", publishApiUrl);
        ResponseEntity<String> response = RestTemplateClientUtility.buildRestTemplate(publishApiUrl,
                method,
                httpHeaders,
                publishMessageRequest,
                String.class);
        log.debug("After Making API call to publish message..");
        return response;
    }
}
