package com.ecommerce.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class PickupKafkaListener {
	
	@KafkaListener(topics = "order-confirmed", groupId = "pickup-group")
	public void consume(String message) {
		 System.out.println("Raw Kafka Message:");
		    System.out.println(message);
	
	}
	
	@KafkaListener(topics = "order-confirmed", groupId = "notification-group")
	public void notificationConsumer(String message) {
	    System.out.println("Notification Service: " + message);
	}
	
	
	@KafkaListener(topics = "order-confirmed", groupId = "analytics-group")
	public void analyticsConsumer(String message) {
	    System.out.println("Analytics Service: " + message);
	}
}
