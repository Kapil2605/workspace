package com.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.ProductEntity;
import com.ecommerce.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	@Transactional
	public ProductEntity createProduct(ProductEntity product) {
		return productRepository.save(product);
	}

	@Transactional
	public ProductEntity getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Transactional
	public List<ProductEntity> getAllProducts() {
		return productRepository.findAll();
	}

	@Transactional
	public List<ProductEntity> searchProducts(String keyword) {
		return productRepository.findByNameContainingIgnoreCase(keyword);
	}

	

	@Transactional
	public void reduceStock(Long id, int qty) {

	        ProductEntity product = productRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        int updatedStock = product.getStock() - qty;

	        if (updatedStock < 0) {
	            throw new RuntimeException("Insufficient stock for product: " + product.getName());
	        }

	        product.setStock(updatedStock);
	        productRepository.save(product);
	    }
}
