package com.kodewala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kodewala.entity.Product;
import com.kodewala.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	
	@Cacheable(value = "products", key = "#id")
	public Product getProductById(Long id) {

		System.out.println("Fetching from DB...");

		// simulateSlowService();

		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
}
