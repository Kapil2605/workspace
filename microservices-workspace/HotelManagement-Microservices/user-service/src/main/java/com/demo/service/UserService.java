package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.external.Rating;
import com.demo.repository.UserRepository;

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

public User getUser(int id){

 User user=repo.findById(id).get();

 List<Rating> ratings=ratingService.getRatings(id);

 user.setRatings(ratings);

 return user;
}
}
