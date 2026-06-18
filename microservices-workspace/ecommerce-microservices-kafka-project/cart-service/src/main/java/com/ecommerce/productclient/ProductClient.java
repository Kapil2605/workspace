package com.ecommerce.productclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "product-service",configuration = TracingFeignConfig.class)
public interface ProductClient {

	@GetMapping("/products/{id}")
	public ProductResponse getProduct(@PathVariable Long id);
}
