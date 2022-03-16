package com.projet.ferme.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_calendary_poultry")
public class CalendaryPoultry {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String calendaryName;
	
	private String intervention;
	
	private Boolean make;
	
	private Date date;

	@Column(name="date_created")
	private Date createdOn;
	
	@Column(name="last_updated")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name="poultry_id")
	private Poultry poultry;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCalendaryName() {
		return calendaryName;
	}

	public void setCalendaryName(String calendaryName) {
		this.calendaryName = calendaryName;
	}

	public String getIntervention() {
		return intervention;
	}

	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}

	public Boolean getMake() {
		return make;
	}

	public void setMake(Boolean make) {
		this.make = make;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/*
	 * public Poultry getPoultry() { return poultry; }
	 */

	public void setPoultry(Poultry poultry) {
		this.poultry = poultry;
	}
	
}
