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
	public String listPurchaseProduct(ModelMap model) {

		return "purchaseProduct";
	}

	@GetMapping("/purchaseProduct/add/{productId}")
	public String addPurchaseProduct(@PathVariable Long productId,  HttpSession session) {

		Product product = productService.getProductById(productId);

		if (session.getAttribute("purchaseProducts") == null) {
			List<PurchaseProduct> purchaseProducts = new ArrayList<PurchaseProduct>();
			purchaseProducts.add(new PurchaseProduct(product, 1));
			session.setAttribute("purchaseProducts", purchaseProducts);
		} else {
			List<PurchaseProduct> purchaseProducts = (List<PurchaseProduct>) session.getAttribute("purchaseProducts");
			int index = isExists(productId, purchaseProducts);
			if (index == -1) {
				purchaseProducts.add(new PurchaseProduct(product, 1));

			} else {
				int quantity = purchaseProducts.get(index).getQuantity() + 1;
				purchaseProducts.get(index).setQuantity(quantity);

			}

			session.setAttribute("purchaseProducts", purchaseProducts);

		}

		return "redirect:/purchaseProduct";
	}
	
	@GetMapping("/purchaseProduct/remove/{productId}")
	public String removePurchaseProduct(@PathVariable Long productId,  HttpSession session) {

		Product product = productService.getProductById(productId);
		
		List<PurchaseProduct> purchaseProducts = (List<PurchaseProduct>) session.getAttribute("purchaseProducts");
		
		
		for(int i =0 ; i < purchaseProducts.size(); i++) {
			 if (purchaseProducts.get(i).getProduct().getId() == productId) {
				 int quantity = purchaseProducts.get(i).getQuantity() - 1;
				 purchaseProducts.get(i).setQuantity(quantity);
				 if(quantity < 1) {
					 purchaseProducts.remove(i);
				 }
			 }
	
		}
		
//		session.setAttribute("purchaseProducts", purchaseProducts);
		

		return "redirect:/purchaseProduct";
	}
	
	
	

	private int isExists(Long productId, List<PurchaseProduct> purchaseProducts) {
		for (int i = 0; i < purchaseProducts.size(); i++) {
			if (purchaseProducts.get(i).getProduct().getId() == productId) {
				return i;
			}
		}
		return -1;
	}

}
