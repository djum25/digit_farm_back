package com.projet.ferme.entity;

import java.sql.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Out extends TimeModel{
	
	private Date date;
	
	private Integer quantity;
	
	private Integer valeur;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}
}
