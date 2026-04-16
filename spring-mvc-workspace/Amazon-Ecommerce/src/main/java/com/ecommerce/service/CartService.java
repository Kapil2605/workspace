package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.dto.CartItemDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;


@Service
public class CartService {

	@Autowired
    private  CartItemRepository cartItemRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private ProductRepository productRepository;

    CartService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }
	
	//add to cart
	@Transactional
	public void addToCart(Long productId) {

	    // 1. Get cart (create if not exists)
	    Cart cart;
	    if (cartRepository.findAll().isEmpty()) {
	        cart = new Cart();
	    } else {
	        cart = cartRepository.findAll().get(0);
	    }

	    // 2. Get product
	    Product product = productRepository.findById(productId).get();

	    // 3. Create new cart item
	    CartItem item = new CartItem();
	    item.setProduct(product);
	    item.setQuantity(1);
	    item.setPriceAtTime(product.getPrice().getAmount());

	    // 4. Add to cart
	    cart.addItem(item);

	    // 5. Save cart
	    cartRepository.save(cart);
	}
	
	//get all cart items
	//get all cart items
		@Transactional
		public List<CartItemDTO> getCartItems() {

		    Cart cart = cartRepository.findById(1L)
		            .orElseThrow();

		    List<CartItemDTO> result = new ArrayList<>();

		    for (CartItem item : cart.getItems()) {
		        result.add(new CartItemDTO(
		                item.getProduct().getName(),
		                item.getQuantity(),
		                item.getPriceAtTime()
		        ));
		    }

		    return result;
		}
	
	
}
