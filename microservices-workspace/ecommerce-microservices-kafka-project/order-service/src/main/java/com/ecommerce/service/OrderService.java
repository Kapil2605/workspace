package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.client.CartClient;
import com.ecommerce.client.ProductClient;
import com.ecommerce.client.UserClient;
import com.ecommerce.dto.CartItemResponse;
import com.ecommerce.dto.CartResponse;
import com.ecommerce.dto.OrderItemKafka;
import com.ecommerce.dto.OrderResponseKafka;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.dto.UserResponse;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.exception.EmptyCartException;
import com.ecommerce.exception.InsufficientStockException;
import com.ecommerce.kafka_integration.KafkaConfig;
import com.ecommerce.repository.OrderRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService {

	@Autowired
    private  OrderRepository orderRepository;
	
	@Autowired
    private  CartClient cartClient;
	
	@Autowired
	private UserClient userClient;
	
	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private KafkaConfig kafkaConfig;

    public Order placeOrder(Long userId) {

    	//communicate with feign client to call cart service  and user service
        CartResponse cart =cartClient.getCart(userId);

        UserResponse user =userClient.getUser(userId);
        
        
        if (cart.getItems() == null || cart.getItems().isEmpty()) {
        	throw new EmptyCartException("Cart is empty. Please add products first.");
        }
        //calculating total price of cart
        double total = 0;

        //creating order
        Order order=new Order();
        order.setUserId(userId);
        order.setStatus(OrderStatus.ORDER_RECEIVED);
        order.setUseEmail(user.getEmail());
        order.setUserAddress(user.getAddress());
        
        
        
        for (CartItemResponse item : cart.getItems()) {
        	//validating stock before placing order
        	ProductResponse product =productClient.getProduct(item.getProductId());
        	if (product.getStock() < item.getQuantity()) {
                throw new InsufficientStockException(
                        product.getName()
                        + " has only "
                        + product.getStock()
                        + " items available"
                );
            }
        	//calculating total for order
            total += item.getPrice()* item.getQuantity();
            
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(item.getProductId());
            orderItem.setProductName(item.getProductName());
            orderItem.setPrice(item.getPrice());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setOrder(order);
            
            order.getItems().add(orderItem);
      
        }
        
        
        order.setTotalAmount(total);
        
        
        //save order created response to OrderResponseKakfa for kafka use
        Order savedOrder=orderRepository.save(order);
        cartClient.clearCart(userId);

        //calling kafka method
        publishOrderCreatedEvent(savedOrder);
        return savedOrder;
    }

    public void publishOrderCreatedEvent(Order savedOrder) {

        OrderResponseKafka event = new OrderResponseKafka();

        event.setOrderId(savedOrder.getId());
        event.setEmail(savedOrder.getUserEmail());
        event.setAmount(savedOrder.getTotalAmount());
        event.setStatus(savedOrder.getStatus());
        event.setUserId(savedOrder.getUserId());

        List<OrderItemKafka> kafkaItems = new ArrayList<>();

        for (OrderItem item : savedOrder.getItems()) {

            OrderItemKafka dto = new OrderItemKafka();

            dto.setProductId(item.getProductId());
            dto.setProductName(item.getProductName());
            dto.setPrice(item.getPrice());
            dto.setQuantity(item.getQuantity());

            kafkaItems.add(dto);
        }

        event.setItems(kafkaItems);

        //kafka work
        kafkaConfig.publishOrderCreated(
                String.valueOf(savedOrder.getUserId()),
                event
        );
    }
    
    
    
    
    public Order updateStatus(Long orderId,OrderStatus status) {

        Order order =orderRepository.findById(orderId)
                        .orElseThrow();

        order.setStatus(status);

        return orderRepository.save(order);
    }
    
    
    public Order getOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow();
    }
    
	@CircuitBreaker(name = "kafkaOrderServiceBreaker", fallbackMethod = "kafkaOrderServiceFallback")
	public void placeDummyOrder() {
		//kafka work
		kafkaConfig.dummyOrderPlaced();
	}
	
	public ResponseEntity<?> kafkaOrderServiceFallback(Long userId, Exception ex) {
		System.out.println("Kafka service unavailable : " + ex.getMessage());
		return ResponseEntity.ok("Kafka Service is currently unavailable");
	}
}
