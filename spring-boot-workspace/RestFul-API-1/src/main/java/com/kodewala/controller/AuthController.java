package com.kodewala.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.entity.Otp;
import com.kodewala.entity.User;
import com.kodewala.repository.AuthRepository;
import com.kodewala.repository.OtpRepository;
import com.kodewala.service.AuthService;
import com.kodewala.service.EmailService;

@RestController
@RequestMapping("/api/v2/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private EmailService emailService;
	

	@PostMapping("/register")
	public ResponseEntity registerUser(@Validated @RequestBody User user) {
		
		
		User responseUser=authService.registerUser(user);
		
		Map<String,Object>response=new HashMap<>();
		
		response.put("id", responseUser.getId());
		response.put("user", responseUser);
		response.put("status","User created successfully");
		
		
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestParam("email") String email,@RequestParam("password") String password){
		
		User loginUserData=authService.login(email, password);
		
		Map<String,Object>response=new HashMap<>();
		
		response.put("id", loginUserData.getId());
		response.put("user", loginUserData);
		response.put("status","User login successfully");
		return ResponseEntity.ok().body(response);
	}
	
	
	//forgot password
	@PostMapping("/forgot-password")
    public ResponseEntity<?> sendOtp(@RequestParam("phoneNo") String phoneNo) {
        Otp values=authService.sendOtp(phoneNo);
        
        Map<String,Object>response=new HashMap<>();
		
		response.put("otp", values.getOtp());
		response.put("status","Otp send successfully");
        return ResponseEntity.ok().body(response);
    }
	
	//reset password
	 @PostMapping("/reset-password")
	    public ResponseEntity<?> resetPassword(
	            @RequestParam String phoneNo,
	            @RequestParam String otp,
	            @RequestParam String newPassword) {

	        return ResponseEntity.ok(
	                authService.resetPassword(phoneNo, otp, newPassword)
	        );
	    }
	 
	 @PostMapping("/forgot-password-email")
	 public ResponseEntity<?> sendEmailOtp(
	         @RequestParam String email
	 ) {

	     String response =
	             authService.sendEmailOtp(email);

	     Map<String, Object> map = new HashMap<>();

	     map.put("message", response);

	     return ResponseEntity.ok(map);
	 }
	 
	 @PostMapping("/reset-password-email")
	 public ResponseEntity<?> resetPasswordEmail(

	         @RequestParam String email,

	         @RequestParam String otp,

	         @RequestParam String newPassword
	 ) {

	     return ResponseEntity.ok(

	             authService.resetPasswordByEmail(
	                     email,
	                     otp,
	                     newPassword
	             )
	     );
	 }
	 
	 
}

