package com.demo.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;
    private String customerName;
    private String item;
    private int quantity;
    private double price;
    private String status; // PLACED, CONFIRMED, DISPATCHED, DELIVERED
}
