package com.projet.ferme.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_chickenCoop")
public class ChickenCoop extends LocalModel{
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="chickenCoop")
	private Set<Poultry> poultry;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chickenCoop")
	private Set<UseFor> useFor;

	/*
	 * public Set<Poultry> getPoultry() { return poultry; }
	 */

	public void setPoultry(Set<Poultry> poultry) {
		this.poultry = poultry;
	}
}
