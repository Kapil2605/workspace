package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Rating;
import com.demo.repository.RatingRepository;

@RestController
@RequestMapping("/ratings")
public class RatingController {

@Autowired
private RatingRepository repo;

@PostMapping
public Rating save(@RequestBody Rating r){
 return repo.save(r);
}

@GetMapping("/user/{userId}")
public List<Rating> getByUser(@PathVariable int userId){
 return repo.findByUserId(userId);
}
}