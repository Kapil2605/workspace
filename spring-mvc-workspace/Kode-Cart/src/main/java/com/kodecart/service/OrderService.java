package com.kodecart.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodecart.entity.Cart;
import com.kodecart.entity.Order;
import com.kodecart.entity.OrderItem;
import com.kodecart.entity.Product;
import com.kodecart.entity.User;
import com.kodecart.repository.OrderRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Transactional
    public void placeOrder(User user) throws Exception {
        List<Cart> cartItems = cartService.getCartByUser(user);
        if (cartItems.isEmpty()) {
            throw new Exception("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(new Date());

        double totalAmount = 0.0;
        List<OrderItem> orderItems = new ArrayList<>();

        for (Cart cart : cartItems) {
            Product product = cart.getProduct();
            if (product.getQuantity() < cart.getQuantity()) {
                throw new Exception("Insufficient stock for product: " + product.getName());
            }

            // Reduce stock
            product.setQuantity(product.getQuantity() - cart.getQuantity());
            productService.saveProduct(product);

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setPrice(product.getPrice());
            item.setQuantity(cart.getQuantity());

            orderItems.add(item);
            totalAmount += (product.getPrice() * cart.getQuantity());
        }

        order.setTotalAmount(totalAmount);
        order.setOrderItems(orderItems);

        orderRepository.save(order);
        cartService.clearCart(user);
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUserOrderByOrderDateDesc(user);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAllByOrderByOrderDateDesc();
    }
}
