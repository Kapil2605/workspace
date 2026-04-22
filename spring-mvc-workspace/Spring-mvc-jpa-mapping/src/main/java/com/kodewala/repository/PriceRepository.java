package com.kodewala.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodewala.entity.Price;

public interface PriceRepository extends JpaRepository<Price, Integer>{

}
