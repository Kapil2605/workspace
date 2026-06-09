package com.ecommerce.service;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderRequest;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private KafkaService kafkaService;

	public void placeOrder(OrderRequest orderRequest) {
		OrderEntity entity = new OrderEntity();

		entity.setItemName(orderRequest.getItemName());
		entity.setStatus(orderRequest.getStatus());

		orderRepository.save(entity); // Interacting with database

		// Send data to kafka topic.....
		
		
			kafkaService.sendMessage("order-confirmed", null, orderRequest);
	}

}