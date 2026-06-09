package com.demo.order.consumer;

import com.demo.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderConsumer {

    /**
     * Listens for order status updates published by the Pickup Service.
     * Topic: order-status-updates
     */
    @KafkaListener(
            topics = "${kafka.topic.order-status}",
            groupId = "order-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeOrderStatusUpdate(
            @Payload Order order,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset
    ) {
        log.info("=== Order Service Received Status Update ===");
        log.info("Topic: {} | Partition: {} | Offset: {}", topic, partition, offset);
        log.info("Order ID    : {}", order.getOrderId());
        log.info("Customer    : {}", order.getCustomerName());
        log.info("Item        : {} x{}", order.getItem(), order.getQuantity());
        log.info("New Status  : {}", order.getStatus());
        log.info("===========================================");

        // Add business logic here — e.g., update DB, send email, trigger notification
        handleStatusUpdate(order);
    }

    private void handleStatusUpdate(Order order) {
        switch (order.getStatus()) {
            case "CONFIRMED"   -> log.info("Order {} confirmed. Notifying customer.", order.getOrderId());
            case "DISPATCHED"  -> log.info("Order {} dispatched. Sending tracking info.", order.getOrderId());
            case "DELIVERED"   -> log.info("Order {} delivered. Closing order.", order.getOrderId());
            default            -> log.warn("Unknown status '{}' for order {}", order.getStatus(), order.getOrderId());
        }
    }
}
