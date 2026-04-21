package com.kodewala.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodewala.entity.CartItem;
import com.kodewala.service.CartService;

@Controller
public class MyController {
	
	@Autowired
	private CartService cartService;

	@GetMapping("/get-all")
	public String searchByPrice(@RequestParam("priceAtTime") Long priceAtTime,Model model) {
		List<CartItem>list=cartService.getByPrice(priceAtTime);
		model.addAttribute("cart", list);
		System.out.println(list);
		return "result";
	}
}
