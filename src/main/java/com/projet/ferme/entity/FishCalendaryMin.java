package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbl_fish_calendar_min")
public class FishCalendaryMin extends MinCalendary{
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private FishCategory category;

	public FishCategory getCategory() {
		return category;
	}

	public void setCategory(FishCategory category) {
		this.category = category;
	}

	
}
