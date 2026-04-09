package com.zepto.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_info")
public class ProductEntity {

	@Id
	private String productId;
	@Column
	private String name;
	@Column
	private String qty;
	@Column
	private String description;
	@Column
	private String price;
	@Column
	private String soldBy;
	
	public ProductEntity() {
	}

	// Parameterized Constructor
    public ProductEntity(String productId, String name, String qty, String description, String price, String soldBy) {
        this.productId = productId;
        this.name = name;
        this.qty = qty;
        this.description = description;
        this.price = price;
        this.soldBy = soldBy;
    }

    // Getters
    public String getproductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public String getSoldBy() {
        return soldBy;
    }

    // Setters
    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

}