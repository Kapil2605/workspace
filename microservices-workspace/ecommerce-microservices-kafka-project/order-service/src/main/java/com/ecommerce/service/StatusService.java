package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ecommerce.client.ProductClient;
import com.ecommerce.dto.OrderItemKafka;
import com.ecommerce.dto.OrderResponseKafka;
import com.ecommerce.dto.PaymentStatusEvent;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class StatusService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Autowired
	private ProductClient productClient;
	

	public void updateOrder(Long orderId, OrderStatus status) {

		Order order = orderRepository.findById(orderId).orElseThrow();

		order.setStatus(status);
	    orderRepository.save(order);
	}

	@Transactional
	public void sendNotificationEvent(Long orderId, OrderStatus status) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow();

        OrderResponseKafka event = new OrderResponseKafka();

        event.setOrderId(order.getId());
        event.setUserId(order.getUserId());
        event.setEmail(order.getUserEmail());
        event.setAmount(order.getTotalAmount());
        event.setStatus(status);
        List<OrderItemKafka> kafkaItems = order.getItems()
                .stream()
                .map(this::mapToKafkaItem)
                .toList();

        event.setItems(kafkaItems);

        kafkaTemplate.send("update-notification-status-topic", event);
    }
	
	private OrderItemKafka mapToKafkaItem(OrderItem item) {

	    OrderItemKafka dto = new OrderItemKafka();

	    dto.setProductId(item.getProductId());
	    dto.setProductName(item.getProductName());
	    dto.setQuantity(item.getQuantity());
	    dto.setPrice(item.getPrice());

	    return dto;
	}

	@Transactional
	public void reduceStock(Long orderId) {

	    Order order = orderRepository.findById(orderId)
	            .orElseThrow();

	    for (OrderItem item : order.getItems()) {

	        ProductResponse product = productClient.getProduct(item.getProductId());

	        int newStock = product.getStock() - item.getQuantity();

	        if (newStock < 0) {
	            throw new RuntimeException(
	                    "Insufficient stock for product: " + product.getName()
	            );
	        }

	        // call product service instead of repository
	        productClient.reduceStock(product.getId(), item.getQuantity());
	    }
	}
}
