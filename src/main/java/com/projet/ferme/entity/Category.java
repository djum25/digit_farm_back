package com.projet.ferme.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Category extends TimeModel{
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
