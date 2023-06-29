package org.kafka.KakfaService.KafkaClient;

import org.kafka.KakfaService.Model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class APIClient {

    private static final String API_URL = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";

    private final RestTemplate restTemplate;

    @Autowired
    public APIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Payload> fetchDataFromAPI() {
        Payload[] response = restTemplate.getForObject(API_URL, Payload[].class);
        return Arrays.asList(response);
    }

}
