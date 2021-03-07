package com.sportyshoes.pojo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class PurchaseId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7532305534119692452L;

	
	private User user;
	
	
	private Product product;
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
