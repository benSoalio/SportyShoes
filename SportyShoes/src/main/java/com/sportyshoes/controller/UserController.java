package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.sportyshoes.pojo.User;
import com.sportyshoes.service.UserService;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userService;
	@GetMapping("/users")
	public String getAllUsers(ModelMap model) {
		List <User> users = userService.getAllUsers();
		
		model.put("users", users);
		return "listUser";
	}
	

}
