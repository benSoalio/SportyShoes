package com.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.pojo.Purchase;
import com.sportyshoes.pojo.User;
import com.sportyshoes.repositories.PurchaseRepository;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	public Purchase save(Purchase purchase) {

		return purchaseRepository.save(purchase);
	}

	public List<Purchase> getAllPurchases() {
		List<Purchase> purchases = new ArrayList<>();

		purchaseRepository.findAll().forEach(purchases::add);

		return purchases;

	}

	public List<Purchase> getAllPurchasesByUser(User user) {
		List<Purchase> purchases = new ArrayList<>();

//		purchaseRepository.FindByUser(user).forEach(purchases::add);

		return purchases;

	}
	
	public Purchase getPurchaseById(Long Id){
		
		Optional<Purchase> purchaseOpt = purchaseRepository.findById(Id);
		Purchase purchase = new Purchase();
		if(purchaseOpt.isPresent()) {
			 purchase = purchaseOpt.get();
			 
		 }
		return  purchase;
	}

}
