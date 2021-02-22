package com.sportyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.pojo.User;

public interface UserRepository  extends  JpaRepository<User, Long> {

	User findByUsername(String username);
	
	

}
