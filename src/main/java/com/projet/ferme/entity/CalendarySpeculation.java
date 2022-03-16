package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_calendary_speculation")
public class CalendarySpeculation extends Calendary{
	
	@ManyToOne
	@JoinColumn(name="speculation_id")
	private Speculation speculation;

	public void setSpeculation(Speculation speculation) {
		this.speculation = speculation;
	}
	
}
