package com.kodewala.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.Otp;
import com.kodewala.entity.User;

public interface OtpRepository extends JpaRepository<Otp, Integer>{

	Optional<Otp> findByPhoneNo(String phoneNo);

	Optional<Otp> findByEmail(String email);

	void deleteByEmail(String email);
	
}
