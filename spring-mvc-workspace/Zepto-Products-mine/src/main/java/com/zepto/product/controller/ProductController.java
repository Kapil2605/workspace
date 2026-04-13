package com.zepto.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zepto.product.entity.ProductEntity;
import com.zepto.product.request.ProductRequest;
import com.zepto.product.request.ProductResponse;
import com.zepto.product.service.IProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ProductController {

	@Autowired
	IProductService iProductService;
	
	
	@GetMapping("createProduct")
	public String redirectToCreatePage() {
	    return "create-product"; 
	}
	
	
	
	@PostMapping("uploadProduct")
	public String uploadProduct(@ModelAttribute ProductRequest productRequest, Model model) {

		// Calling service layer
		ProductResponse productResponse = iProductService.createProduct(productRequest);

		model.addAttribute("response", productResponse);

		return "product-display";
	}

	//get all product 
	@GetMapping("viewProducts")
	public  String viewAllProduct(Model model) {
		List<ProductEntity>data=iProductService.getAll();
	    // send data to JSP
	    model.addAttribute("products", data);

	    return "view-all-product";
	}
	
	//get product by id
	@GetMapping("searchProductById")
	public String searchProductPage() {
	    return "search-product"; 
	}
	
	@PostMapping("searchProduct")
	public String getProductById(@RequestParam("productId") String id, Model model) {

	    ProductEntity product = iProductService.getById(id);

	    model.addAttribute("product", product);
	    
	    return "display-product-by-id"; 
	}
	
	// delete product by id
	@GetMapping("deleteProduct")
	@ResponseBody
	public String deleteProduct(@RequestParam("productId") String id, Model model) {

	    String response = iProductService.deleteById(id);

	    model.addAttribute("msg", response);

	    return "delete-success"; 
	}
	
	//go to edit form page
	@GetMapping("editProduct")
	public String editProduct(@RequestParam("productId") String id, Model model) {

	    ProductEntity product = iProductService.getById(id);

	    model.addAttribute("product", product);

	    return "edit-product"; 
	}
	
	@PostMapping("updateProduct")
	@ResponseBody
	public String updateProduct(@ModelAttribute ProductRequest request,@RequestParam("productId") String id, Model model) {

	    String response = iProductService.updateProduct(request,id);

	    model.addAttribute("response", response);

	    return "update-success";
	}
}

