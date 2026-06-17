package com.ecommerce.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ecommerce.dto.OrderResponseKafka;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.PaymentStatus;
import com.ecommerce.repository.PaymentRepository;

@Component
public class PaymentKafkaListener {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@KafkaListener(topics = "order-created-topic", groupId = "payment-service-group")
	public void consume(OrderResponseKafka event) {

		//consume by payment service now its status updated
        Payment payment = new Payment();

        payment.setOrderId(event.getOrderId());
        payment.setAmount(event.getAmount());
        payment.setStatus(PaymentStatus.PAYMENT_PENDING);

        paymentRepository.save(payment);
    }
}
