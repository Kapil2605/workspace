package com.ecommerce.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping("/create")
	public UserEntity createUser( @RequestBody UserRequest userRequest) {
		
		return userService.createUser(userRequest);
	}

	@GetMapping("/{id}")
	public UserEntity getUser(@PathVariable Long id) {
		log.info("Cart id request Received");

		log.info("TraceId={}, SpanId={}");
		return userService.getUser(id);
	}
}
