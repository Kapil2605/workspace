package com.ecommerce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.entity.OrderEntity;
import com.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
    private  OrderService orderService;

    @PostMapping
    public ResponseEntity<?> placeOrder(@RequestBody OrderEntity order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }
}