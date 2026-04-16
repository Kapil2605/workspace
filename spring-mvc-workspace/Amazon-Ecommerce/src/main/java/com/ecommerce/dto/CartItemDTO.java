package com.ecommerce.dto;

public class CartItemDTO {

    private String productName;
    private int quantity;
    private Double price;

    public CartItemDTO(String productName, int quantity, Double price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // getters
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    
    
}