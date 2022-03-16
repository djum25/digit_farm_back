package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_calendary_cattle")
public class CalendaryCattle extends Calendary{
	
	@ManyToOne
	@JoinColumn(name="cattle_id")
	private Cattle cattle;

	/*
	 * public Cattle getCattle() { return cattle; }
	 */

	public void setCattle(Cattle cattle) {
		this.cattle = cattle;
	}
	
	
}
