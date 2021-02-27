package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sportyshoes.pojo.Category;
import com.sportyshoes.service.CategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	
	@GetMapping("/category")
	public String getAllCategory(ModelMap model) {
		List<Category> categories = categoryService.getAllCategory();
		model.put("categories", categories);
		return "listCategory";
	}
	
	@GetMapping("/category/{categoryId}")
	public String getCategory(@PathVariable Long categoryId, ModelMap model) {
		Category category = categoryService.getCategoryById(categoryId);
		model.put("category", category);
		return "detailCategory";
	}
	
	@GetMapping("/newCategory")
	public String newCategory(ModelMap model) {
		model.put("category", new Category());
		return "formCategory";
	}
	
	@PostMapping("/category")
	public String addCategory(Category category, ModelMap model) {
		
		categoryService.save(category);
		Long categoryId = category.getId();
		model.put("category", category);
		return "redirect:/category/"+categoryId;
	}
	
	
	
	
	
}
