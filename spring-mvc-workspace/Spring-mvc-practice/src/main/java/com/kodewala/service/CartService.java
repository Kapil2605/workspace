package com.kodewala.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodewala.entity.CartItem;
import com.kodewala.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Transactional
	public List<CartItem> getByPrice(Long price) {
		return cartRepository.findByPriceAtTime(price);
	}
	
}
