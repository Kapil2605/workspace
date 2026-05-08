package com.kodewala.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.User;
import com.kodewala.exception.UserNotFoundException;
import com.kodewala.repository.AuthRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

	@Autowired
	private AuthRepository authRepository;

	// get all user
	@Transactional
	public List<User> getall() {
		return authRepository.findAll();
	}

	// get by id
	@Transactional
	public User getById(String id) {
		return authRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
	}
}
