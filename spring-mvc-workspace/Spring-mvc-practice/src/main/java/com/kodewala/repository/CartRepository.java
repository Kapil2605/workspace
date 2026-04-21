package com.kodewala.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.CartItem;

public interface CartRepository extends JpaRepository<CartItem, Long>{
	List<CartItem> findByPriceAtTime(Long priceAtTime);
}
