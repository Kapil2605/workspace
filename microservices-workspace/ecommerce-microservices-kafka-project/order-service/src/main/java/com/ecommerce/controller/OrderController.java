package com.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@PostMapping("/place/{userId}")
	public Order placeOrder(@PathVariable Long userId) {
		log.info("Order Request Received");

		log.info("TraceId={}, SpanId={}");
		return orderService.placeOrder(userId);
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id) {

		return orderService.getOrder(id);
	}

	@PutMapping("/{id}/status")
	public Order updateStatus(@PathVariable Long id, 
			@RequestParam OrderStatus status) {

		return orderService.updateStatus(id, status);
	}

}
