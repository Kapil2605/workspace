package com.kodewala.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kodewala.entity.Product;
import com.kodewala.service.ProductService;


@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@GetMapping("/get-by-name")
	public String findByProductName(@RequestParam("name") String name,Model model) {
		List<Product>prd=productService.findProducts(name);
		System.out.println(prd);
		model.addAttribute("product", prd);
		return "display-product";
	}
	
	@GetMapping("/searchByPriceRange")
	public String searchPrice(@RequestParam("price1") float price1, @RequestParam("price2") float price2,  Model model) {
		System.out.println("Price1"+price1);
		System.out.println("Price2"+price2);
		List<Product>prd=productService.searchProductsByPrice(price1,price2);
		System.out.println(prd);
		model.addAttribute("product", prd);
		return "display-product";
	}
}
