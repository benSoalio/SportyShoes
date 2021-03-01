package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.pojo.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	Category findByName(String name);

}
