package org.kafka.KakfaService;

import org.kafka.KakfaService.KafkaClient.APIClient;
import org.kafka.KakfaService.KafkaClient.KafkaProducerService;
import org.kafka.KakfaService.Model.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class KakfaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(KakfaServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(APIClient apiClient, KafkaProducerService kafkaProducerService) {
		return args -> {
			// Fetch data from API
			List<Payload> payloads = apiClient.fetchDataFromAPI();

			// Send data to Kafka topic
			kafkaProducerService.sendMessageToKafka(payloads);
		};
	}
}
