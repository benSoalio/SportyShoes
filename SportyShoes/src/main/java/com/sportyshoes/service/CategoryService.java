package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.pojo.Category;
import com.sportyshoes.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category save(Category category) {
		
		return categoryRepository.save(category);
	}
	
	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<>();
		
		categoryRepository.findAll().forEach(categories::add);
		
		return categories;
	}
	
	public Category getCategoryById(Long id) {
		
		 Optional<Category> categoryOpt =  categoryRepository.findById(id);
		 Category category = new Category();
		 if(categoryOpt.isPresent()) {
			 category = categoryOpt.get();
			 
		 }
		 return category;
	}
	

}
