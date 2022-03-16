package com.projet.ferme.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Stock extends TimeModel{
	
	private Integer quantity;
	
	private String type;
	
	private String description;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
