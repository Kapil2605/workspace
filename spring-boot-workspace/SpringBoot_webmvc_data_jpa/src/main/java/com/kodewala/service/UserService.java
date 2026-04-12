package com.kodewala.service;

import com.kodewala.entities.User;

public interface UserService {
	public boolean registerUser(User user);
	
	User loginUser(String email,String password);
}
