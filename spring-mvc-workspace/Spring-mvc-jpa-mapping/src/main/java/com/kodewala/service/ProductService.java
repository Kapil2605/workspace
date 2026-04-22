package com.kodewala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodewala.dto.ProductRequest;
import com.kodewala.entity.Price;
import com.kodewala.entity.Product;
import com.kodewala.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void createProduct(ProductRequest productRequest) {
		Product product = new Product();
		product.setName(productRequest.getName());
		product.setDescription(productRequest.getDescription());
		product.setStock_quantity(productRequest.getStock_quantity());
		
		Price price=new Price();
		price.setProductPrice(productRequest.getProductPrice());
		price.setCurrency(productRequest.getCurrency());
	    price.setProduct(product);
	    
	    
		product.setPrice(price);
		
		 productRepository.save(product);
	}

	@Transactional
	public List<Product> searchProduct(String name) {
		
		return productRepository.taskToSearchByName(name.trim());
	}

	public void update(ProductRequest request) {
		Product product = productRepository.findById((long) request.getId()).orElse(null);

	    if (product != null) {

	        product.setName(request.getName());
	        product.setDescription(request.getDescription());
	        product.setStock_quantity(request.getStock_quantity());
	        product.getPrice().setProductPrice(request.getProductPrice());
	        product.getPrice().setCurrency(request.getCurrency());

	        productRepository.save(product);
	    }
		
	}
	
	
}
