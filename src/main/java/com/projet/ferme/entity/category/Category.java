package com.projet.ferme.entity.category;

import javax.persistence.MappedSuperclass;

import com.projet.ferme.entity.utils.TimeModel;

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
