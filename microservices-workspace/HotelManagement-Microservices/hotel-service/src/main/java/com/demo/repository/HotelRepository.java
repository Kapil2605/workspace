package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Hotel;


public interface HotelRepository extends JpaRepository<Hotel,Integer>{
}
