package com.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Payment;
import com.ecommerce.service.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@PostMapping("/{orderId}/success")
	public Payment success(@PathVariable Long orderId) {

		return paymentService.pay(orderId, true);
	}

	@PostMapping("/{orderId}/failed")
	public Payment failed(@PathVariable Long orderId) {

		return paymentService.pay(orderId, false);
	}
}