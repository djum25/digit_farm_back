package com.projet.ferme.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name =  "tbl_shop")
@Entity
public class Shop extends TimeModel{

	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="shop")
	private Set<Cashier> cashiers;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
