package com.projet.ferme.entity;

public class CalendarFrequency {

	private Long id;
	
	private String name;
	
	private String intervention;
	
	private int start;
	
	private int frequence;
	
	private int end;
	
	private Fish fish;
	
	private Poultry poultry;
	
	private Speculation speculation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntervention() {
		return intervention;
	}

	public void setIntervention(String intervention) {
		this.intervention = intervention;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getFrequence() {
		return frequence;
	}

	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public Speculation getSpeculation() {
		return speculation;
	}

	public void setSpeculation(Speculation speculation) {
		this.speculation = speculation;
	}

	public Poultry getPoultry() {
		return poultry;
	}

	public void setPoultry(Poultry poultry) {
		this.poultry = poultry;
	}
	
}
