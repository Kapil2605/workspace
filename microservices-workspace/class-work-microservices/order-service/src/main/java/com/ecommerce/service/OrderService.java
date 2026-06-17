package com.ecommerce.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.client.InvoiceService;
import com.ecommerce.entity.OrderEntity;
import com.ecommerce.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    InvoiceService invoiceService;
	
    public OrderEntity placeOrder(OrderEntity order) {
    	String response=invoiceService.message();
    	System.out.println("Response from feign client invoice: "+response);
        return orderRepository.save(order);
    }
}