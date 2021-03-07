package com.sportyshoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.pojo.PurchaseProduct;
import com.sportyshoes.pojo.PurchaseProductPk;
import com.sportyshoes.repositories.PurchaseProductRepository;

@Service
public class PurchaseProductService {
	
	@Autowired
	private PurchaseProductRepository purchaseProductRepository;
	
	public PurchaseProduct save(PurchaseProduct purchaseProduct) {
		
		return purchaseProductRepository.save(purchaseProduct);
	}
	
	
	public List<PurchaseProduct> getAllPurchaseProduct(){
		
		return (List<PurchaseProduct>) purchaseProductRepository.findAll();
	}
	
	public PurchaseProduct getPurchaseProductById(PurchaseProductPk pk){
		
		Optional <PurchaseProduct> purchaseProductOpt = purchaseProductRepository.findById(pk);
		PurchaseProduct purchaseProduct = new PurchaseProduct();
		
		if(purchaseProductOpt.isPresent()) {
			 purchaseProduct = purchaseProductOpt.get();
			 
		 }
		return  purchaseProduct;
	}
	
	public void deletePurchaseProduct(PurchaseProduct purchaseProduct) {
		purchaseProductRepository.delete(purchaseProduct);
	}

}
