package com.sportyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class productController {
	
	@GetMapping("/products")
	public String getProducts(ModelMap model) {
		return "product";
	}
	
	@GetMapping("/createProduct")
	public String createProduct() {
		return "productForm";
	}
	
	@PostMapping("/createProduct")
	public String Product() {
		return "redirect:/product";
	}

}
