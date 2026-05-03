package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

	List<Rating> findByUserId(int userId);

}
