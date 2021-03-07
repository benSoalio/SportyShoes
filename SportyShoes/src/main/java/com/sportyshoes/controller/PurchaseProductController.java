package com.sportyshoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sportyshoes.pojo.Product;
import com.sportyshoes.pojo.Purchase;
import com.sportyshoes.pojo.PurchaseProduct;
import com.sportyshoes.service.ProductService;
import com.sportyshoes.service.PurchaseProductService;

@Controller
public class PurchaseProductController {
		
		@Autowired
		private PurchaseProductService purchaseProductService;
		
		@Autowired
		private ProductService productService;
		
		
		@GetMapping("/purchaseProduct")
		public String listPurchaseProduct (ModelMap model) {
			
			
			return "purchaseProduct";
		}
		
		
		@GetMapping("/purchaseProduct/add/{productId}")
		public String addPurchaseProduct(@PathVariable Long productId, ModelMap model, HttpSession session) {
			
			Product product = productService.getProductById(productId);
			Purchase purchase = new Purchase();
			
			if (session.getAttribute("purchaseProducts") == null) {
				List <PurchaseProduct> purchaseProducts = new ArrayList<PurchaseProduct>();
				purchaseProducts.add(new PurchaseProduct(purchase ,product, 1));
				session.setAttribute("purchaseProducts", purchaseProducts);
			} else {
				
				
			}
			
			
		
			
			return "redirect:/purchaseProduct";
		}
		
		
}
