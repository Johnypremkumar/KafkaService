package org.kafka.KakfaService.KafkaClient;

import org.kafka.KakfaService.Model.Payload;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String TOPIC_NAME = "your-topic-name";

    @KafkaListener(topics = TOPIC_NAME, groupId = "your-consumer-group-id")
    public void consumeMessage(Payload payload) {
        System.out.println("Received payload from Kafka: " + payload);
        // Perform any required processing or storing of the payload
    }
}
