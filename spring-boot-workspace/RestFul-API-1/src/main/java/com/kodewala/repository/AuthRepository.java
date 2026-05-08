package com.kodewala.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.Otp;
import com.kodewala.entity.User;


public interface AuthRepository extends JpaRepository<User, String>{

	Optional<User>  findByEmail(String email);
	
	Optional<User>  findByEmailAndPassword(String email,String password);

	Optional<User> findByPhoneNo(String phoneNo);
	
}
