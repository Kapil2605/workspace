package com.ecommerce.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.dto.UserResponse;

@FeignClient(name = "user-service",configuration = TracingFeignConfig.class)
public interface UserClient {

	@GetMapping("/user/{id}")
	UserResponse getUser(@PathVariable Long id);
}