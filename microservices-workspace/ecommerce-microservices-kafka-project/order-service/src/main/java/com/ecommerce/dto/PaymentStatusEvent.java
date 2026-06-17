package com.ecommerce.dto;

import com.ecommerce.entity.OrderStatus;

public class PaymentStatusEvent {

    private Long orderId;
    private OrderStatus status;

    public PaymentStatusEvent() {}

    public PaymentStatusEvent(Long orderId, OrderStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}