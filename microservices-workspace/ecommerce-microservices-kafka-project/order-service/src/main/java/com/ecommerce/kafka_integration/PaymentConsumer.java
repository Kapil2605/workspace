package com.ecommerce.kafka_integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderResponseKafka;
import com.ecommerce.dto.PaymentStatusEvent;
import com.ecommerce.entity.OrderStatus;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.StatusService;

@Service
public class PaymentConsumer {

    @Autowired
    private StatusService statusService;

    @KafkaListener(topics = "payment-status-topic", groupId = "order-group")
    public void consume(PaymentStatusEvent event) {

        System.out.println("Order Service received: " + event.getOrderId());

        // 1. update order status
        OrderStatus status =event.getStatus();
        statusService.updateOrder(event.getOrderId(), status);

	     // 2. reduce stock ONLY on success
        if (status == OrderStatus.PAYMENT_SUCCESS) {
            statusService.reduceStock(event.getOrderId());
        }
        
        // 2. send notification event (ENRICHED FROM DB)
        statusService.sendNotificationEvent(event.getOrderId(), status);
    }
}
