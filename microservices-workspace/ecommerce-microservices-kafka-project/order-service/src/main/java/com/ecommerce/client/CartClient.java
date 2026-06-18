package com.ecommerce.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.dto.CartResponse;

@FeignClient(name = "cart-service",configuration = TracingFeignConfig.class)
public interface CartClient {

	@GetMapping("/cart/{userId}")
	CartResponse getCart(@PathVariable Long userId);

	@DeleteMapping("/cart/{userId}")
	void clearCart(@PathVariable Long userId);
}