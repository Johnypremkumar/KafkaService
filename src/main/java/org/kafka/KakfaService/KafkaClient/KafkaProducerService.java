package org.kafka.KakfaService.KafkaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.kafka.KakfaService.Model.Payload;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, Payload> kafkaTemplate;
    private static final String TOPIC_NAME = "your-topic-name";

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Payload> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessageToKafka(List<Payload> payloads) {
        for (Payload payload : payloads) {
            kafkaTemplate.send(TOPIC_NAME, payload);
        }
    }
}
