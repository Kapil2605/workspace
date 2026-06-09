package com.zepto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.service.KafkaService;

@RestController
@RequestMapping("/boy")
public class KafkaController {

	@Autowired
	private KafkaService kafkaService;

	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		for (int i = 0; i <= 10000; i++) {
			this.kafkaService.updateLocation("(" + Math.floor(Math.random() * 100) + " , " + Math.floor(Math.random() * 100) + ")");
		}
		return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);

	}
}
