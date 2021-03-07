package com.sportyshoes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sportyshoes.pojo.Purchase;
import com.sportyshoes.pojo.User;

public interface PurchaseRepository extends CrudRepository<Purchase, Long> {
	
//	List<Purchase> FindByUser(User user);

}
