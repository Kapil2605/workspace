package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.config.AppConstant;
import com.ecommerce.dto.OrderRequest;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private KafkaService kafkaService;

	public void placeOrder(OrderRequest orderRequest) {

		OrderEntity entity = new OrderEntity();
		entity.setProductName(orderRequest.getProductName());
		entity.setPrice(orderRequest.getPrice());
		entity.setQty(orderRequest.getQty());
		entity.setOrderStatus(orderRequest.getOrderStatus());

		if (orderRequest.getOrderStatus().equalsIgnoreCase("ORDER-CONFIRMED")) {
			orderRepository.save(entity);
			kafkaService.sendMessage(AppConstant.ORDER_CONFIRMED_TOPIC, null, orderRequest);
		} else {
			kafkaService.sendMessage(AppConstant.ORDER_UPDATED_TOPIC, null, orderRequest);
		}
	}
}
