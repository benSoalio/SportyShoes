package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.pojo.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
	

}
