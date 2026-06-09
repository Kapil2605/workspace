package com.demo.order.consumer;

import com.demo.order.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderProducer {

    private final KafkaTemplate<String, Order> kafkaTemplate;

    private static final String ORDER_TOPIC = "new-orders";

    /**
     * POST /api/orders — Places a new order and publishes it to Kafka.
     */
    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        // Assign a unique ID if not provided
        if (order.getOrderId() == null || order.getOrderId().isBlank()) {
            order.setOrderId(UUID.randomUUID().toString());
        }
        order.setStatus("PLACED");

        CompletableFuture<SendResult<String, Order>> future =
                kafkaTemplate.send(ORDER_TOPIC, order.getOrderId(), order);

        future.whenComplete((result, ex) -> {
            if (ex != null) {
                log.error("Failed to publish order {}: {}", order.getOrderId(), ex.getMessage());
            } else {
                log.info("Order {} published → topic={} partition={} offset={}",
                        order.getOrderId(),
                        result.getRecordMetadata().topic(),
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset());
            }
        });

        return "Order placed! ID: " + order.getOrderId();
    }
}
