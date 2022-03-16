package com.projet.ferme.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_cattle")
public class Cattle extends TimeModel{
	
	private String name;
	
	private String gender;
	
	private Boolean present;
	
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="enclosure_id")
	private Enclosure enclosure;
	
	@ManyToOne
	@JoinColumn(name="category_id", referencedColumnName="id")
	private CattleCategory category;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cattle")
	private Set<CalendaryCattle> calendary;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="cattle")
	private Set<OutCattle> outCattle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFamily() {
		return category.getFamily();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getPresent() {
		return present;
	}

	public void setPresent(Boolean present) {
		this.present = present;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Enclosure getEnclosure() {
		return enclosure;
	}

	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}

	public Set<CalendaryCattle> getCalendary() {
		return calendary;
	}

	public void setCalendary(Set<CalendaryCattle> calendary) {
		this.calendary = calendary;
	}

	public Set<OutCattle> getOutCattle() {
		return outCattle;
	}

	public void setOutCattle(Set<OutCattle> outCattle) {
		this.outCattle = outCattle;
	}

	public CattleCategory getCategory() {
		return category;
	}

	public void setCategory(CattleCategory category) {
		this.category = category;
	}
	
	public String getCategoryName() {
		return category.getName();
	}
	
	public String getEnclosureName() {
		return enclosure.getName();
	}
	
}
