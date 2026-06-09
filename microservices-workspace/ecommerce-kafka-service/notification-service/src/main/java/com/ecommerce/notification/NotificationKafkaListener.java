package com.ecommerce.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationKafkaListener {
	@KafkaListener(topics = "ecommerce-order-updated", groupId = "notification-group")
	public void consume(String message) {
		 System.out.println("Notification send to email:");
		    System.out.println(message);
	
	}
}
