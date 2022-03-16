package com.projet.ferme.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_planting")
public class Planting extends LocalModel{
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="planting")
	private Set<Speculation> speculation;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="planting")
	private Set<Tree> tree;

	/*
	 * public Set<Speculation> getSpeculation() { return speculation; }
	 */

	public void setSpeculation(Set<Speculation> speculation) {
		this.speculation = speculation;
	}

	/*
	 * public Set<Tree> getTree() { return tree; }
	 */

	public void setTree(Set<Tree> tree) {
		this.tree = tree;
	}
	
	
	
}
