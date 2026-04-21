package com.kodewala.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.UserEntity;
import com.kodewala.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity createUser(UserEntity user) {
		
		return userRepository.save(user);
	}
	
	
	
}
