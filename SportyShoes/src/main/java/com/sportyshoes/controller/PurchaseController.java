package com.sportyshoes.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportyshoes.pojo.Product;
import com.sportyshoes.pojo.Purchase;
import com.sportyshoes.pojo.PurchaseProduct;
import com.sportyshoes.pojo.PurchaseProductPk;
import com.sportyshoes.pojo.User;
import com.sportyshoes.service.PurchaseProductService;
import com.sportyshoes.service.PurchaseService;
import com.sportyshoes.service.UserService;

@Controller
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PurchaseProductService purchaseProductService;
	
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
	
	@GetMapping("/checkout")
	public String getCheckout(HttpSession session, @AuthenticationPrincipal User user){
		
		LocalDate dateCreated = LocalDate.now();
		
		List<PurchaseProduct> purchaseProducts = (List<PurchaseProduct>) session.getAttribute("purchaseProducts");
		
		
		Purchase purchase = new Purchase();
		purchase.setDateCreated(dateCreated);
		purchase.setPurchaseProducts(purchaseProducts);
		purchase.setUser(user);
		purchaseService.save(purchase);
		for(PurchaseProduct purchaseProduct : purchaseProducts) {
			Product product = purchaseProduct.getPk().getProduct();
			PurchaseProductPk pk = new PurchaseProductPk();
			pk.setPurchase(purchase);
			pk.setProduct(product);
			purchaseProduct.setPk(pk);
			purchaseProductService.save(purchaseProduct);
		}
		session.removeAttribute("purchaseProducts");
		return "checkout";
	}
}
