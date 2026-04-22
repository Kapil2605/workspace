package com.kodewala.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodewala.dto.ProductRequest;
import com.kodewala.entity.Product;
import com.kodewala.repository.ProductRepository;
import com.kodewala.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductService productService;

	@GetMapping("/createProductForm")
	public String createProductFormLink() {
		return "create-product";
	}
	
	@PostMapping("/submitProduct")
	@ResponseBody
	public  String submitProductForm(@ModelAttribute ProductRequest productRequest,Model model) {
		 productService.createProduct(productRequest);
		 
		 return "sucessfully added";
	}
	
	
	
	//search mapping-----------------
	@GetMapping("/searchProductForm")
	public String searchProductFormLink() {
		return "search-product";
	}
	
	@GetMapping("/submitProductSearch")
	public  String submitSearchProductForm(@RequestParam("name") String name ,Model model) {
		 List<Product>products=productService.searchProduct(name);
		 System.out.println(products);
		 model.addAttribute("product", products);
		 return "display-product";
	}
	
	//update mapping
	@GetMapping("/updateProduct")
	public String updateProductForm(@RequestParam("id") int id,Model model) {
		Product product = productRepository.findById((long) id).orElse(null);
		model.addAttribute("product", product);
		return "update-product";
	}
	
	@PostMapping("/updateProductForm")
	@ResponseBody
	public  String submitupdateProductForm(@ModelAttribute ProductRequest productRequest,Model model) {
		 productService.update(productRequest);
		 model.addAttribute("request", productRequest);
		 return "sucessfully updated";
	}
	
	
	//delete mapping
	@GetMapping("/deleteProduct")
	@ResponseBody
	public String deleteProduct(@RequestParam("id") int id) {
		productRepository.deleteById((long) id);
		return "success-deleted-product";
	}
}
