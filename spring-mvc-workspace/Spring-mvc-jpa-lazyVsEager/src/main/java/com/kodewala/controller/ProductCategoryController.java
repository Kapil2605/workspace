package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodewala.request.CategoryRequest;
import com.kodewala.service.ProductCategoryService;

@Controller
public class ProductCategoryController {

	@Autowired
	ProductCategoryService productCategoryService;

	@PostMapping("createCategory")
	public String createCategory(@ModelAttribute CategoryRequest categoryRequest) {
		productCategoryService.createCategory(categoryRequest);
		return "find-category";
	}

	@GetMapping("findCategory")
	@ResponseBody
	public String getCategory(@RequestParam("categoryId") int categoryId) {
	    productCategoryService.getCategory(categoryId);
	    return "found category";
	}
	
	@GetMapping("findAllCategory")
	@ResponseBody
	public String findAll() {
		productCategoryService.findAllCategory();
		return "category found";
	}
}