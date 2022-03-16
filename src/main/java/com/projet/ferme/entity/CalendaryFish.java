package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_calendary_fish")
public class CalendaryFish extends Calendary{
	
	@ManyToOne
	@JoinColumn(name="fish_id")
	private Fish fish;

	/*
	 * public Fish getFish() { return fish; }
	 */

	public void setFish(Fish fish) {
		this.fish = fish;
	}
	

}
