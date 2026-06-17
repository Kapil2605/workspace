package com.ecommerce.dto;

import com.ecommerce.entity.PaymentStatus;

public class PaymentStatusEvent {

    private Long orderId;
    private PaymentStatus status;

    public PaymentStatusEvent() {}

    public PaymentStatusEvent(Long orderId, PaymentStatus  paymentStatus) {
        this.orderId = orderId;
        this.status = paymentStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public PaymentStatus  getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}