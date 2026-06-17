package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.PaymentStatusEvent;
import com.ecommerce.entity.Payment;
import com.ecommerce.entity.PaymentStatus;
import com.ecommerce.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;

	public Payment pay(Long orderId, boolean success) {

		Payment payment = paymentRepository.findByOrderId(orderId).orElseThrow();

		if (success) {
			payment.setStatus(PaymentStatus.PAYMENT_SUCCESS);
		} else {
			payment.setStatus(PaymentStatus.PAYMENT_FAILED);
		}

		paymentRepository.save(payment);

		PaymentStatusEvent event = new PaymentStatusEvent(orderId, payment.getStatus());

		kafkaTemplate.send("payment-status-topic", event);

		return payment;
	}
}