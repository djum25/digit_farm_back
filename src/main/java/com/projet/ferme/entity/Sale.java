package com.projet.ferme.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "tbl_sale")
public class Sale extends TimeModel{
	
	private Integer price;
	
	private Integer advance;
	
	private Integer account;
	
	private Integer quantity;
	
	private String produit;
	
	private Date date;
	
	@Column(name = "subject_id")
	private String subjectId;
	
	@ManyToOne
	@JoinColumn(name = "cashier_id")
	private Cashier cashier;
	
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAdvance() {
		return advance;
	}

	public void setAdvance(Integer advance) {
		this.advance = advance;
	}

	public Integer getAccount() {
		return account;
	}

	public void setAccount(Integer account) {
		this.account = account;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProduit() {
		return produit;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}
	
}
