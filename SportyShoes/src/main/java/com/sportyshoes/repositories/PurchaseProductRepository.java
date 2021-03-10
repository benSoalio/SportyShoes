package com.sportyshoes.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.pojo.PurchaseProduct;
import com.sportyshoes.pojo.PurchaseProductPk;

public interface PurchaseProductRepository extends CrudRepository<PurchaseProduct, PurchaseProductPk> {
	
}
