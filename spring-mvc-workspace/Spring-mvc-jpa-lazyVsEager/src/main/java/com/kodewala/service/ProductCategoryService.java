package com.kodewala.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.Category;
import com.kodewala.entity.Product;
import com.kodewala.repository.ProductCategoryRepository;
import com.kodewala.request.CategoryRequest;

import jakarta.transaction.Transactional;

@Service
public class ProductCategoryService {

	@Autowired
	ProductCategoryRepository productCategoryRepository;

	@Transactional
	public void getCategory(int categoryID) {
		System.out.println("ProductCategoryService.getCategory() START");
		Optional<Category> category = productCategoryRepository.findById(categoryID);

		System.out.println("category details " + category.get().getId() + " " + category.get().getCategoryName()
				+ " and product Name : "  +category.get().getProducts());

		System.out.println("ProductCategoryService.getCategory() END");

	}

	public void createCategory(CategoryRequest categoryRequest) {

	    System.out.println("START");

	    // check existing category
	    Category category =
	        productCategoryRepository.findByCategoryName(
	            categoryRequest.getCategoryName());

	    // if not found create new
	    if (category == null) {
	        category = new Category();
	        category.setCategoryName(categoryRequest.getCategoryName());
	        category.setDescription(categoryRequest.getCategoryDescription());
	        category.setStatus(categoryRequest.getCategoryStatus());
	    }

	    // create product
	    Product product = new Product();
		product.setDescription(categoryRequest.getProductDescription());
		product.setName(categoryRequest.getProductName());
	    product.setStatus(categoryRequest.getProductStatus());

	    
		List<Product> products = new ArrayList<>();
		products.add(product);
		category.setProducts(products);

		product.setCategory(category);

	    // save
	    productCategoryRepository.save(category);

	    System.out.println("END");
	}

	public void findAllCategory() {
		Iterable<Category>cat=productCategoryRepository.findAll();
		
		Iterator<Category>categItr=cat.iterator();
		while(categItr.hasNext()) {
			System.out.println(categItr.next().getCategoryName());
		}
		
	}
}