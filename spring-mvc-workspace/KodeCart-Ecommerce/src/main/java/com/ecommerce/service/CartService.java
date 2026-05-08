package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.CartItemDTO;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.User;
import com.ecommerce.repository.CartRepository;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    // RETURN DTO INSTEAD OF ENTITY
    public List<CartItemDTO> getCartByUser(User user) {

        List<Cart> cartList = cartRepository.findByUser(user);
        List<CartItemDTO> dtoList = new ArrayList<>();

        for (Cart cart : cartList) {

            Product product = cart.getProduct();

            CartItemDTO dto = new CartItemDTO(
            		product.getId(),
                    product.getName(),
                    cart.getQuantity(),
                    product.getPrice() != null ? product.getPrice().getAmount() : 0.0
            );

            dtoList.add(dto);
        }

        return dtoList;
    }

    // ADD TO CART
    public void addToCart(User user, Integer productId, Integer quantity) {

        Product product = productService.searchProductById(productId);

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
        cartRepository.deleteAll(cartRepository.findByUser(user));
    }
}