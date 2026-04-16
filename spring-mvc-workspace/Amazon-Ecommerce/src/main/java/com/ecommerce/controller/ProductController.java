package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecommerce.dto.ProductRequest;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/reseller")
	public String resellerPage(Model model) {

	    List<Product> products = productService.getAllProducts();
	    model.addAttribute("products", products);

	    return "reseller-dashboard";
	}
	
	
	//create product
	@GetMapping("/createProductForm")
	public String createProductFormPage() {
		return "product-form";
	}
	
	@PostMapping("/create-product")
    public String createProduct(@ModelAttribute ProductRequest request) {
        productService.saveProduct(request);
        return "redirect:/reseller";
    }
	
	//get product by id
	@GetMapping("/searchProduct")
	public String searchProduct(@RequestParam("keyword") String keyword, Model model) {

	    List<Product> products = productService.searchProducts(keyword);

	    model.addAttribute("products", products);

	    return "reseller-dashboard";
	}
	
	//update product
	@GetMapping("/editProductForm")
	public String editProductForm(@RequestParam("id") Long id, Model model) {

	    Product product = productRepository.findById(id).orElse(null);

	    model.addAttribute("product", product);

	    return "edit-product-form";
	}
	
	@PostMapping("/update-product")
	public String updateProduct(@ModelAttribute ProductRequest request) {

	    productService.updateProduct(request);

	    return "redirect:/reseller";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("id") Long id) {

	    if (productRepository.existsById(id)) {
	        productRepository.deleteById(id);
	    }

	    return "redirect:/reseller";
	}
}
