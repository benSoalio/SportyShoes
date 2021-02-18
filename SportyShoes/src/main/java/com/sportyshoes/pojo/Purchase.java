package com.sportyshoes.pojo;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity

public class Purchase { 
	
	
	private PurchaseId pk;
	
	@EmbeddedId
	public PurchaseId getPk() {
		return pk;
	}
	public void setPk(PurchaseId pk) {
		this.pk = pk;
	}
	private Date date;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
