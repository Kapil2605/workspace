package com.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.dto.CartItemDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.User;
import com.ecommerce.service.CartService;


import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	// View Cart
	@GetMapping("/cart")
    public String viewCart(HttpSession session, Model model) {
		User user = (User) session.getAttribute("loggedInUser");

	    if (user == null) {
	        return "redirect:/loginPage";
	    }

	    model.addAttribute("cartItems", cartService.getCartByUser(user));

	    return "cart-page";
    }
    
	// Add to Cart
    @PostMapping("/addToCart")
    public String addToCart( @RequestParam("productId") Integer productId,
            @RequestParam("quantity") Integer quantity, HttpSession session) {
        User user = (User) session.getAttribute("loggedInUser");
        if (user == null) return "redirect:/loginPage";

        cartService.addToCart(user, productId, quantity);
        return "redirect:/cart";
    }

}
