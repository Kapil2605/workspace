package com.ecommerce.entity;

public enum OrderStatus {

	ORDER_RECEIVED,
	PAYMENT_PENDING,
    PAYMENT_SUCCESS,
    PAYMENT_FAILED,
    ORDER_CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
}
