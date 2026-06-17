package com.ecommerce.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ecommerce.dto.OrderResponseKafka;
import com.ecommerce.service.EmailService;

@Component
public class NotificationConsumer {

	@Autowired
	private EmailService emailService;

	@KafkaListener(topics = "order-created-topic", groupId = "notification-group")
	public void consume(OrderResponseKafka event) {

	    emailService.sendOrderMail(
	            event.getEmail(),
	            event.getOrderId(),
	            event.getStatus(),
	            event.getItems(),
	            event.getAmount()
	    );
	}

	@KafkaListener(topics = "update-notification-status-topic", groupId = "notification-group")
	public void consumeOrderStatusUpdate(OrderResponseKafka event) {

	    emailService.sendPaymentStatusMail(
	            event.getEmail(),
	            event.getOrderId(),
	            event.getStatus(),
	            event.getItems(),
	            event.getAmount()
	    );
	}
}