package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sportyshoes.pojo.User;
import com.sportyshoes.repositories.UserRepository;
import com.sportyshoes.security.Authority;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User save(User user) {
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		
		user.getAuthorities().add(authority);
		return userRepo.save(user);
	} 
	
	public List<User> getAllUsers(){
		List <User> users = new ArrayList<>();
		
		 userRepo.findAll().forEach(users::add);
		 return users;
	}

}
