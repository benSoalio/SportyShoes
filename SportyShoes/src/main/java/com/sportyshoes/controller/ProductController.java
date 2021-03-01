package com.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sportyshoes.pojo.Category;
import com.sportyshoes.pojo.Product;
import com.sportyshoes.service.CategoryService;
import com.sportyshoes.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private  CategoryService categoryService;
	
	@GetMapping("/products")
	public String getAllProduct(ModelMap model) {
		List<Product> products = productService.getAllProduct();
		model.put("products", products);
		return "listProduct";
	}
	
	@GetMapping("/product/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model) {
		Product product = productService.getProductById(productId);
		model.put("product", product);
		return "detailProduct";
	}
	
	@GetMapping("/newProduct")
	public String newProduct(ModelMap model) {
		Product newProduct = new Product();
		List<Category> categories = categoryService.getAllCategory();
		
		model.addAttribute("newProduct", newProduct);
		model.addAttribute("categories", categories);
		return "formProduct";
	}
	
	@PostMapping("/product")
	public String addProduct(@ModelAttribute("newProduct") Product newProduct, ModelMap model) {
		
		
//		 category = categoryService.findByName(category.getName());
//		System.out.println(newProduct.getCategory().getId());
//		System.out.println(newProduct.getName());
			
		productService.save(newProduct);
		Long productId =newProduct.getId();
		
		model.put("product", newProduct);
		return "redirect:/product/"+productId;
	}

}
