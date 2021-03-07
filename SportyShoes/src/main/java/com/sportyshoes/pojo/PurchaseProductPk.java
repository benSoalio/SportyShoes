package com.sportyshoes.pojo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class PurchaseProductPk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7532305534119692452L;

	
	private Purchase purchase;
	
	
	private Product product;
	
	@ManyToOne
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
