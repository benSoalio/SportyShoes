package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.pojo.Category;
import com.sportyshoes.pojo.Product;
import com.sportyshoes.repositories.CategoryRepository;
import com.sportyshoes.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public Product save(Product product) {
		
//		product.setCategory(category);
		return productRepository.save(product);
		
	}
	
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<>();
		
		productRepository.findAll().forEach(products::add);
		
		return products;
	}
	
	public Product getProductById(Long id) {
		
		 Optional<Product> productOpt =  productRepository.findById(id);
		 Product product = new Product();
		 if(productOpt.isPresent()) {
			 product = productOpt.get();
			 
		 }
		 return product;
	}

}
