package com.kodecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodecart.entity.Cart;
import com.kodecart.entity.Product;
import com.kodecart.entity.User;
import com.kodecart.repository.CartRepository;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public List<Cart> getCartByUser(User user) {
        return cartRepository.findByUser(user);
    }

    public void addToCart(User user, Integer productId, Integer quantity) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            Cart existingCart = cartRepository.findByUserAndProductId(user, productId);
            if (existingCart != null) {
                existingCart.setQuantity(existingCart.getQuantity() + quantity);
                cartRepository.save(existingCart);
            } else {
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setProduct(product);
                newCart.setQuantity(quantity);
                cartRepository.save(newCart);
            }
        }
    }

    public void removeFromCart(Integer cartId) {
        cartRepository.deleteById(cartId);
    }

    public void clearCart(User user) {
        List<Cart> items = cartRepository.findByUser(user);
        cartRepository.deleteAll(items);
    }
}
