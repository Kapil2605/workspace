package com.kodewala.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.entity.User;

import com.kodewala.service.UserService;

@RestController
@RequestMapping("/api/v2/auth")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllUser() {
		List<User>users=userService.getall();
		
		return ResponseEntity.ok().body(users);
	}
	
	//get by id
	@GetMapping("/get-By-Id")
	public ResponseEntity<?> getById(@RequestParam("id") String id) {
		User users=userService.getById(id);
		
		Map<String,Object>response=new HashMap<>();
		
		response.put("id", users.getId());
		response.put("user", users);
		response.put("status","User fetched successfully");
		
		return ResponseEntity.ok().body(response);
	}
	
	
	
}
