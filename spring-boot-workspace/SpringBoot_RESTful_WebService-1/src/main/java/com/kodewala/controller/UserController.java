package com.kodewala.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.entity.UserEntity;
import com.kodewala.service.IUserService;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/create-user")
	public UserEntity createUser(@RequestBody UserEntity user) {
		return userService.createUser(user);
	}
}
