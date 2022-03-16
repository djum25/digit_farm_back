package com.projet.ferme.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_enclosure")
public class Enclosure extends LocalModel{
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="enclosure")
	private Set<Cattle> cattle;
	/*
	 * public Set<Cattle> getCattle() { return cattle; }
	 */

	public void setCattle(Set<Cattle> cattle) {
		this.cattle = cattle;
	}
	
	
}
