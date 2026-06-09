package com.ecommerce.delivery;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DeliveryKafkaListener {
	
	@KafkaListener(topics = "ecommerce-order-confirmed", groupId = "delivery-group")
	public void consume(String message) {
		 System.out.println("Order confirmed out for delivery:");
		    System.out.println(message);
	
	}
}
