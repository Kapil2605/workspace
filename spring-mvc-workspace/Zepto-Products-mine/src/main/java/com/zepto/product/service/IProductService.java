package com.zepto.product.service;

import java.util.List;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;

public interface IProductService {

	public ProductResponse createProduct(ProductRequest productRequest);
	
	//get all products
	public List<ProductEntity> getAll();
	
	//get product by id
	public ProductEntity getById(String id);
	
	//delete product
	public String deleteById(String id);
	
	String updateProduct(ProductRequest request);
	
}