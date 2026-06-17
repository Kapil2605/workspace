package com.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entity.CartEntity;
import com.ecommerce.entity.CartItemEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

	Optional<CartEntity> findByUserId(Long userId);

}
