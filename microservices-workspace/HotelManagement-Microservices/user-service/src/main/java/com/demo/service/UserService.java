package com.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.external.Rating;
import com.demo.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.transaction.Transactional;

@Service
public class UserService {
 
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private RatingService ratingService;
	
	@Transactional
	public User save(User user){
		System.out.println("user  name: "+user.getName());
		System.out.println("user  email: "+user.getEmail());
	 return repo.save(user);
	}
	
	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	public User getUser(int id){
	
		 User user=repo.findById(id).get();
		
		 List<Rating> ratings=ratingService.getRatings(id);
		
		 user.setRatings(ratings);
		
		 return user;
	}
	
	// Fallback Method
    public User ratingHotelFallback(int id, Exception ex) {

        System.out.println("Fallback executed because service is down");

        User user = repo.findById(id).get();

        Rating rating = new Rating();

        rating.setRating(0);
        rating.setFeedback("Rating Service is temporarily unavailable");

        user.setRatings(List.of(rating));

        return user;
    }

    //get all user
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "userFallback")
	public List<User> getAllUser() {
		return repo.findAll();
	}
    
    public List<User> userFallback(RequestNotPermitted  ex){

        List<User> users = new ArrayList<>();

        User user = new User();

        user.setName("Fallback User");
        user.setEmail("Too many requests");

        users.add(user);

        return users;
    }
}
