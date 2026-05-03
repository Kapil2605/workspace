package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public User save(@RequestBody User user) {
		System.out.println("user name: "+user.getName());
		System.out.println("user email: "+user.getEmail());
		return service.save(user);
	}

	@GetMapping("/{id}")
	public User get(@PathVariable int id) {
		return service.getUser(id);
	}
}