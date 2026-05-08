package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/reseller")
	public String resellerPage(Model model, HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
        if (user == null || !user.getRole().equals("ADMIN")) return "redirect:/loginPage";
        
	    List<Product> products = productService.getAllProducts();
	    model.addAttribute("products", products);

	    return "reseller-dashboard";
	}
	
	@GetMapping("/customer")
	public String CustomerHomePage(Model model,HttpSession session) {
		User user = (User) session.getAttribute("loggedInUser");
        if (user.getRole().equals("ADMIN")) return "redirect:/loginPage";
        
	    List<Product> products = productService.getAllProducts();
	    model.addAttribute("products", products);
	    return "customer-home";
	}
	
	@GetMapping("/customer/searchProduct")
	public String searchProduct(@RequestParam("keyword") String keyword, Model model) {
		System.out.println("Keyowrd: "+keyword );
	    List<Product> products = productService.searchProducts(keyword);
	    for(Product p:products) {
	    	System.out.println(p.getInventory().getQuantity());
	    }
	    model.addAttribute("products", products);

	    return "customer-home";
	}
	
	@GetMapping("/viewProduct")
	public String viewProductPage(@RequestParam("id") int id, Model model) {
	    
	    // Call the service method that returns Optional<Product>
	    Product product = productService.searchProductById(id);
	    
	    // Add the unwrapped Product object to the model
	    if(!product.getStatus().equalsIgnoreCase("inactive")) {
	        model.addAttribute("product", product);
	    }
	    
	    return "view-product-detail";
	}
	
	
}
