package com.kodewala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodewala.entity.Product;
import com.kodewala.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findProducts(String name){
		return productRepository.testQueryByName(name.trim());
	}

	public List<Product> searchProductsByPrice(float price1 ,float price2) {
		return productRepository.findByPriceBetween(price1,price2);
	}

	public List<Product> searchProductsByPriceQty(float price, int stockQuantity) {
		return productRepository.test(price, stockQuantity);
	}
}
