package com.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entity.CartEntity;
import com.ecommerce.entity.CartItemEntity;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	CartService cartService;
	
	@Autowired
	CartRepository cartRepository;

	private static final Logger log = LoggerFactory.getLogger(CartController.class);

	// add to cart
	@PostMapping("/add")
	public CartEntity addToCart(@RequestParam Long userId, @RequestParam Long productId,
			@RequestParam Integer quantity) {

		return cartService.addToCart(userId, productId, quantity);
	}

	// get cart details
	@GetMapping("/{userId}")
	public CartEntity getCart(@PathVariable Long userId) {
		log.info("Cart id request Received");

		log.info("TraceId={}, SpanId={}");
		return cartService.getCart(userId);
	}

	// delete cart items
	@DeleteMapping("/{userId}")
	public void clearCart(@PathVariable Long userId) {

		CartEntity cart = cartRepository.findByUserId(userId).orElseThrow();

		cart.getItems().clear();

		cartRepository.save(cart);
	}
}
