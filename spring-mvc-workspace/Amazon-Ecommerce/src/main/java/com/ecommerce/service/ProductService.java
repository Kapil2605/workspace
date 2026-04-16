package com.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.entity.Inventory;
import com.ecommerce.entity.Price;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
	public void saveProduct(ProductRequest request) {

	    Product product = new Product();
	    product.setName(request.getName());
	    product.setDescription(request.getDescription());
	    product.setStatus(request.getStatus());

	    // Price
	    Price price = new Price();
	    price.setCurrency(request.getCurrency());
	    price.setAmount(Double.parseDouble(request.getPrice()));

	    // Inventory
	    Inventory inventory = new Inventory();
	    inventory.setQuantity(Integer.parseInt(request.getQuantity()));

	    // Relationships
	    product.setPrice(price);
	    product.setInventory(inventory);

	    productRepository.save(product);
	}
	
	@Transactional
	public List<Product> getAllProducts() {
	    return productRepository.findAll();
	}
	
	//search by name
	public List<Product> searchProducts(String keyword) {
	    return productRepository.findByNameContainingIgnoreCase(keyword);
	}
	
	public Optional<Product> searchProductById(int id) {
	    return productRepository.findById((long) id);
	}
	//update product
	public void updateProduct(ProductRequest request) {

	    Product product = productRepository.findById(request.getId()).orElse(null);

	    if (product != null) {

	        product.setName(request.getName());
	        product.setDescription(request.getDescription());
	        product.setStatus(request.getStatus());

	        product.getPrice().setAmount(Double.parseDouble(request.getPrice()));
	        product.getPrice().setCurrency(request.getCurrency());

	        product.getInventory().setQuantity(Integer.parseInt(request.getQuantity()));

	        productRepository.save(product);
	    }
	}

	
}
