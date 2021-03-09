package com.sportyshoes.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class PurchaseProduct {

	private PurchaseProductPk pk;

	private Integer quantity;

	@EmbeddedId
	public PurchaseProductPk getPk() {
		return pk;
	}

	public void setPk(PurchaseProductPk pk) {
		this.pk = pk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Transient
	public Product getProduct() {
		return this.pk.getProduct();
	}

	public PurchaseProduct(Purchase purchase, Product product, Integer quantity) {

		pk = new PurchaseProductPk();
		pk.setPurchase(purchase);
		pk.setProduct(product);
		this.quantity = quantity;
	}

	public PurchaseProduct( Product product, Integer quantity) {
		
		pk = new PurchaseProductPk();
		pk.setProduct(product);
		this.quantity = quantity;
	}

	public PurchaseProduct() {
		super();
	}

	@Transient
	public void setProduct(Product product) {
		this.pk.setProduct(product);
	}

	@Transient
	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

}
