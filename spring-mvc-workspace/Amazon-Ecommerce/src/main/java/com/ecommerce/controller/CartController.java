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
import com.ecommerce.entity.CartItem;
import com.ecommerce.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	
	// View Cart
	@GetMapping("/cart")
	public String viewCart(Model model) {

		List<CartItemDTO> cartItems = cartService.getCartItems();
		model.addAttribute("cartItems", cartItems);
	    return "cart-page";
	}
    
    
	// Add to Cart
    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") Long productId) {
        cartService.addToCart(productId);
        return "redirect:/cart";
    }
}
