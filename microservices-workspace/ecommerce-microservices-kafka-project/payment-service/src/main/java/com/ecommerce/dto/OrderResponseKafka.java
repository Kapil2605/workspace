package com.ecommerce.dto;

import java.util.List;

public class OrderResponseKafka {

	private Long orderId;
	private Long userId;
	private String email;
	private Double amount;
	private OrderStatus status;
	private List<OrderItemKafka> items;
	
	public List<OrderItemKafka> getItems() {
		return items;
	}
	public void setItems(List<OrderItemKafka> items) {
		this.items = items;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus orderStatus) {
		this.status = orderStatus;
	}
}
