package com.ecommerce.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    private String name;
    @Column
    private String description;
    
    @Column
    private String status;
    
    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Price price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItems;
    
    // getters & setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
	    this.price = price;
	    if (price != null) {
	        price.setProduct(this); 
	    }
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	public void setInventory(Inventory inventory) {
	    this.inventory = inventory;
	    if (inventory != null) {
	        inventory.setProduct(this); 
	    }
	}

	

	
}
