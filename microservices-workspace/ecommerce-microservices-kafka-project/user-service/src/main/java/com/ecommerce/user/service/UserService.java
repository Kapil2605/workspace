package com.ecommerce.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.user.dto.UserRequest;
import com.ecommerce.user.entity.UserEntity;
import com.ecommerce.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	//create user
	public UserEntity createUser(UserRequest userRequest) {
		UserEntity user=new UserEntity();
		user.setName(userRequest.getName());
		user.setPhone(userRequest.getPhone());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());
		user.setAddress(userRequest.getAddress());
		user.setPincode(userRequest.getPincode());
		
		return userRepository.save(user);
	}

	//get-user by id
	public UserEntity getUser(Long id) {
		
		return userRepository.findById(id)
		        .orElseThrow(() -> new RuntimeException("User not found"));
	}
	
}
