package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.demo.entity.Hotel;
import com.demo.repository.HotelRepository;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelRepository repo;

	@PostMapping
	public Hotel save(@RequestBody Hotel h) {
		System.out.println("hotel  about: " + h.getAbout());
		System.out.println("hotel  anme: " + h.getName());
		return repo.save(h);
	}

	@GetMapping("/{id}")
	public Hotel get(@PathVariable int id) {
		return repo.findById(id).get();
	}
}