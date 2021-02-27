package com.sportyshoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/")
	public String rootView () {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	

}
