package com.projet.ferme.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_speculation")
public class Speculation extends TimeModel{
	
	private String name;
	
	@Column(name="date_seed")
	private Date seedDate;
	
	private boolean present;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="speculation")
	private Set<CalendarySpeculation> calendary;
	
	@ManyToOne
	@JoinColumn(name="seed_id",referencedColumnName="id")
	private Seed seed;
	
	@ManyToOne
	@JoinColumn(name="planting_id")
	private Planting planting;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="speculation") 
	 private Set<HarvestSpeculation> harvest;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSeedDate() {
		return seedDate;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public void setSeedDate(Date seedDate) {
		this.seedDate = seedDate;
	}

	public Seed getSeed() {
		return seed;
	}

	public void setSeed(Seed seed) {
		this.seed = seed;
	}
	
	 public String getSeedName() {
		 return seed.getSeedName(); 
	}

	public Set<CalendarySpeculation> getCalendary() {
		return calendary;
	}

	public void setCalendary(Set<CalendarySpeculation> calendary) {
		this.calendary = calendary;
	}

	public Planting getPlanting() {
		return planting;
	}

	public void setPlanting(Planting planting) {
		this.planting = planting;
	}

	/*
	 * public Set<HarvestSpeculation> getHarvest() { return harvest; }
	 */
	
	public String getPlantingName() {
		return planting.getName();
	}
	
	public void setHarvest(Set<HarvestSpeculation> harvest) {
		this.harvest = harvest;
	}
	
	
}
