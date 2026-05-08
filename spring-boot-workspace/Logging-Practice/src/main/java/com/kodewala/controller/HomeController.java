package com.kodewala.controller;


import org.slf4j.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	private Logger logger= LoggerFactory.getLogger("HomeController.class");
	
	@GetMapping("/home")
	public String homePage(@RequestParam(defaultValue = "default value",required = false)String value) {
		logger.info("hello {}",value);
		logger.trace("hello {}",value);
		logger.warn("hello {}",value);
		logger.debug("hello {}",value);
		logger.error("hello {}",value);
		
		return "home page";
	}
}
