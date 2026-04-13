package com.zepto.product.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.repository.ProductRepository;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;
import com.zepto.product.service.IProductService;

// All the business logic
@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	@Transactional
	@Override
	public ProductResponse createProduct(ProductRequest productRequest) {

		String productName = productRequest.getProductName();
		String qty = productRequest.getQty();

		String description = productRequest.getDescription();

		String price = productRequest.getPrice();
		String soldBy = productRequest.getSoldBy();;

		System.out.println("ProductServiceImpl -->  Received from Seller " + productName + " " + qty + " " + description
				+ " " + price + " " + soldBy);

		String input = productName;

		// Calling DAO / Repository Layer
		String productId = productRepository.uploadProduct(productName,qty,description,price,soldBy);

		ProductResponse productResponse = new ProductResponse();
		if (productId != null) {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMsg("You product has been uploaded. It will be live on catalog soon!!");
		} else {
			productResponse.setProductId(productId);
			productResponse.setConfirmationMsg("Unable to upload the product!");
		}
		return productResponse;
	}
	
	
	//get all products
	@Transactional
	@Override
	 public  List<ProductEntity> getAll() {
	        return productRepository.getAllProducts();
	    }
	
	
	@Override
	@Transactional
	public ProductEntity getById(String id) {
	    return productRepository.getProductById(id);
	}
	
	@Override
	@Transactional
	public String deleteById(String id) {

	    boolean deleteStatus = productRepository.deleteProduct(id);

	    if (deleteStatus) {
	        return "Product Deleted Successfully";
	    } else {
	        return "Product Not Found";
	    }
	}


	@Override
	@Transactional
	public String updateProduct(ProductRequest request, String id) {

		// fetch existing product using ID
	    ProductEntity product = productRepository.getProductById(id);

	    if (product == null) {
	        return "Product Not Found";
	    }

	    // update only fields
	    product.setName(request.getProductName());
	    product.setQty(request.getQty());
	    product.setDescription(request.getDescription());
	    product.setPrice(request.getPrice());
	    product.setSoldBy(request.getSoldBy());

	    // no need to set ID again
	    productRepository.updateProductDetails(product);

	    return "Product Updated Successfully";
	}
	
	
	//update product logic
	
}