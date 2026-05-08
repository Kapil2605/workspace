package com.ecommerce.dto;

public class CartItemDTO {

    private Long productId;
    private String productName;
    private int quantity;
    private Double price;

    public CartItemDTO(Long productId, String productName, int quantity, Double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public Double getPrice() { return price; }
}