package com.kodecart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodecart.entity.Cart;
import com.kodecart.entity.User;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUser(User user);
    Cart findByUserAndProductId(User user, Integer productId);
}
