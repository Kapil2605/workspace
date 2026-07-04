package com.ecommerce.service;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.request.AuthRequest;
import com.ecommerce.request.SignupRequest;
import com.ecommerce.response.AuthResponse;
import com.ecommerce.security.JwtUtil;

@Service
public class AuthService {

	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	public AuthService(UserRepository repository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, JwtUtil jwtUtil) {

		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	public String register(SignupRequest request) {

		User user = new User();

		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole());

		repository.save(user);

		return "User Registered Successfully";
	}

	public AuthResponse login(AuthRequest request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		String token = jwtUtil.generateToken(request.getUsername());

		return new AuthResponse(token);
	}
}