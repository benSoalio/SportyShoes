package com.sportyshoes.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity

public class Purchase { 
	
	
	private Long id;
	private LocalDate dateCreated;
	private User user;
	private List<PurchaseProduct> purchaseProducts = new ArrayList<>();
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="pk.purchase")
	public List<PurchaseProduct> getPurchaseProducts() {
		return purchaseProducts;
	}
	public void setPurchaseProducts(List<PurchaseProduct> purchaseProducts) {
		this.purchaseProducts = purchaseProducts;
	}
	
	@Transient
	public Double getTotalPurchasePrice() {
		double sum = 0D;
		List<PurchaseProduct> purchaseProducts = getPurchaseProducts();
		for (PurchaseProduct purchaseProduct : purchaseProducts) {
			sum += purchaseProduct.getTotalPrice();
		}
		return sum;
	}
		
	@Transient
	public int getNumberOfProduct() {
		return purchaseProducts.size();
	}

}
