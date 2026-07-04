package com.ecommerce.kafka_integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderResponseKafka;

@Service
public class KafkaConfig {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public void publishOrderCreated(String userId,OrderResponseKafka event) {

		kafkaTemplate.send("order-created-topic",userId, event);
	}
	
	public void dummyOrderPlaced() {
		kafkaTemplate.send("sample-topic",1);
	}
}
