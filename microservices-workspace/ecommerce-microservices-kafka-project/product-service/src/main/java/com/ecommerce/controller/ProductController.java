package com.ecommerce.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.ProductEntity;
import com.ecommerce.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	// Add Product
    @PostMapping("/create")
    public ProductEntity createProduct(@RequestBody ProductEntity product) {
        return productService.createProduct(product);
    }
    
 // View Product Details
    @GetMapping("/{id}")
    public ProductEntity getProduct(@PathVariable Long id) {
    	log.info("Product id request Received");

		log.info("TraceId={}, SpanId={}");
        return productService.getProductById(id);
    }

    // View All Products
    @GetMapping
    public List<ProductEntity> getAllProducts() {
        return productService.getAllProducts();
    }

    // Search Product
    @GetMapping("/search")
    public List<ProductEntity> searchProducts(@RequestParam String keyword) {
        return productService.searchProducts(keyword);
    }
    
    @PutMapping("/{id}/reduce-stock")
    public void reduceStock(@PathVariable Long id, @RequestParam int qty) {
        productService.reduceStock(id, qty);
    }
}
