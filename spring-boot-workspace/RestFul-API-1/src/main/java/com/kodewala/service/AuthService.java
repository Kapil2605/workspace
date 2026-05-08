package com.kodewala.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.entity.Otp;
import com.kodewala.entity.User;
import com.kodewala.exception.UserEmailAlreadyExistException;
import com.kodewala.exception.UserNotFoundException;
import com.kodewala.repository.AuthRepository;
import com.kodewala.repository.OtpRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthService {

	@Autowired
	private AuthRepository authRepository;
	
	@Autowired
	private OtpRepository otpRepository;
	
	@Autowired
	private EmailService emailService;

	@Transactional
	public User registerUser(User user) {

		Optional<User> existingUser = authRepository.findByEmail(user.getEmail());

		if (existingUser.isPresent()) {
			throw new UserEmailAlreadyExistException("User with email: " + user.getEmail() + " already exists!");
		}

		return authRepository.save(user);
	}

	@Transactional
	public User login(String email, String password) {
		Optional<User> foundUser = authRepository.findByEmailAndPassword(email, password);

		if (foundUser.isEmpty()) {
			throw new UserNotFoundException("Invalid email or password");
		}

		return foundUser.get();

	}

	public Otp sendOtp(String phoneNo) {
		User user=authRepository.findByPhoneNo(phoneNo).orElseThrow(()->new RuntimeException("User not found"));
		
		String otp = String.format("%06d", new Random().nextInt(1000000));
		
		Otp otpEntity = new Otp();
		
		otpEntity.setOtp(otp);
		otpEntity.setPhone(phoneNo);
		otpEntity.setExpiryTime(System.currentTimeMillis() + 5 * 60 * 1000);
		
		otpRepository.save(otpEntity);
		
		// Replace this with SMS API
        System.out.println("OTP is: " + otp);
		
        return otpEntity;
	}

	public String resetPassword(String phoneNo, String otp, String newPassword) {
		Otp otpEntity = otpRepository.findByPhoneNo(phoneNo)
                .orElseThrow(() -> new RuntimeException("OTP not found"));

        if (!otpEntity.getOtp().equals(otp)) {
            throw new RuntimeException("Invalid OTP");
        }

        if (otpEntity.getExpiryTime() < System.currentTimeMillis()) {
            throw new RuntimeException("OTP expired");
        }

        User user = authRepository.findByPhoneNo(phoneNo)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPassword(newPassword); // encrypt in real apps
        authRepository.save(user);

        otpRepository.delete(otpEntity);

        return "Password updated successfully";
	}
	
	
	public String sendEmailOtp(String email) {

	    User user = authRepository.findByEmail(email)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	    // delete old OTP
	    otpRepository.deleteByEmail(email);

	    String otp = String.format("%06d",
	            new Random().nextInt(1000000));

	    Otp otpEntity = new Otp();

	    otpEntity.setEmail(email);
	    otpEntity.setOtp(otp);

	    otpEntity.setExpiryTime(
	            System.currentTimeMillis() + 5 * 60 * 1000
	    );

	    otpRepository.save(otpEntity);

	    // send email
	    emailService.sendOtpEmail(email, otp);

	    return "OTP sent successfully to email";
	}
 
 public String resetPasswordByEmail(
	        String email,
	        String otp,
	        String newPassword
	) {

	    Otp otpEntity = otpRepository.findByEmail(email)
	            .orElseThrow(() ->
	                    new RuntimeException("OTP not found"));

	    if (!otpEntity.getOtp().equals(otp)) {
	        throw new RuntimeException("Invalid OTP");
	    }

	    if (otpEntity.getExpiryTime()
	            < System.currentTimeMillis()) {

	        throw new RuntimeException("OTP expired");
	    }

	    User user = authRepository.findByEmail(email)
	            .orElseThrow(() ->
	                    new RuntimeException("User not found"));

	    user.setPassword(newPassword);

	    authRepository.save(user);

	    otpRepository.delete(otpEntity);

	    return "Password updated successfully";
	}
	
}
