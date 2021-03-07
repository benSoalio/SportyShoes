package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportyshoes.pojo.Purchase;
import com.sportyshoes.service.PurchaseService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	
	@GetMapping("/purchases")
	public String getAllPurchase(ModelMap model) {
		List<Purchase> purchases = purchaseService.getAllPurchases();
		model.put("purchases", purchases);
		return "listPurchase";
	}
	
	@GetMapping("/purchase/{purchaseId}")
	public String getPurchase(@PathVariable Long purchaseId, ModelMap model){
		Purchase purchase = purchaseService.getPurchaseById(purchaseId);
		model.put("purchase", purchase);
		return "detailPurchase";
	}
}
