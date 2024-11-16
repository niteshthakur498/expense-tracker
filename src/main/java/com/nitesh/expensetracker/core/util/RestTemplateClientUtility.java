package com.nitesh.expensetracker.core.util;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class RestTemplateClientUtility {

    private static RestTemplate staticRestTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        staticRestTemplate = this.restTemplate;
    }

    public static <T> ResponseEntity<T> buildRestTemplate(UriComponentsBuilder uriComponentsBuilder,
                                                          HttpMethod httpMethod,
                                                          HttpHeaders httpHeaders,
                                                          Class<T> responseType) {
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return staticRestTemplate.exchange(uriComponentsBuilder.toUriString(), httpMethod, entity, responseType);
    }

    public static <T> ResponseEntity<T> buildRestTemplate(String httpUrl,
                                                          HttpMethod httpMethod,
                                                          HttpHeaders httpHeaders,
                                                          Class<T> responseType) {
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return staticRestTemplate.exchange(httpUrl, httpMethod, entity, responseType);
    }

    public static <T> ResponseEntity<T> buildRestTemplate(String httpUrl,
                                                          HttpMethod httpMethod,
                                                          HttpEntity<String> entity,
                                                          Class<T> responseType) {
        return staticRestTemplate.exchange(httpUrl, httpMethod, entity, responseType);
    }

    public static <T, R> ResponseEntity<T> buildRestTemplate(String httpUrl,
                                                             HttpMethod httpMethod,
                                                             HttpHeaders httpHeaders,
                                                             R requestBody,
                                                             Class<T> responseType) {
        HttpEntity<R> entity = new HttpEntity<>(requestBody, httpHeaders);
        return staticRestTemplate.exchange(httpUrl, httpMethod, entity, responseType);
    }


}
