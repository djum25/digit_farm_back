package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_out_fish")
public class OutFish extends Out{

	
	private Integer poid;
	
	@ManyToOne
	@JoinColumn(name = "fish_id")
	private Fish fish;

	public Integer getPoid() {
		return poid;
	}

	public void setPoid(Integer poid) {
		this.poid = poid;
	}

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}
	
}
