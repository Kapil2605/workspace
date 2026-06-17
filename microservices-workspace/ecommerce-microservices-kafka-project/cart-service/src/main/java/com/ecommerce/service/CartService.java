package com.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.CartEntity;
import com.ecommerce.entity.CartItemEntity;
import com.ecommerce.exception.InsufficientStockException;
import com.ecommerce.productclient.ProductResponse;
import com.ecommerce.productclient.ProductClient;
import com.ecommerce.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	@Autowired
	ProductClient productClient;

	public CartEntity addToCart(Long userId, Long productId, Integer quantity) {

		//checking product details through feign client through product ID
		ProductResponse product = productClient.getProduct(productId);
		
		//finding existing cart with this userID if not found then create one and set userID
		CartEntity cart = cartRepository.findByUserId(userId)
                .orElseGet(() -> {
                    CartEntity c = new CartEntity();
                    c.setUserId(userId);
                    return c;
                });
		
		 CartItemEntity existingItem = cart.getItems()
		            .stream()
		            .filter(item -> item.getProductId().equals(productId))
		            .findFirst()
		            .orElse(null);

		    if (existingItem != null) {

		        int newQuantity = existingItem.getQuantity() + quantity;

		        if (newQuantity > product.getStock()) {
		            throw new InsufficientStockException(
		                    product.getName() +
		                    " has only " +
		                    product.getStock() +
		                    " items available"
		            );
		        }
		        existingItem.setQuantity(newQuantity);

		    } else {

		    	if (quantity > product.getStock()) {
		    	    throw new InsufficientStockException(
		    	            product.getName() +
		    	            " has only " +
		    	            product.getStock() +
		    	            " items available"
		    	    );
		    	}
		         
				//make cart item entity object and set product response there
				CartItemEntity item = new CartItemEntity();
				item.setProductId(product.getId());
				item.setProductName(product.getName());
				item.setPrice(product.getPrice());
				item.setQuantity(quantity);
				item.setCart(cart);
				
				//finally adding cart items to cart
				cart.getItems().add(item);
		    }
		return cartRepository.save(cart);
	}
	
	public CartEntity getCart(Long userId) {
        return cartRepository.findByUserId(userId).orElseThrow();
    }
}
