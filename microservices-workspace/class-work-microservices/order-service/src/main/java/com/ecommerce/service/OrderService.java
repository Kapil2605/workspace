package com.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    
    public OrderEntity placeOrder(OrderEntity order) {
        return orderRepository.save(order);
    }
}