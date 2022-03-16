package com.projet.ferme.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_speculation_calendar_min")
public class SpeculationCalendaryMin extends MinCalendary{
		
		@ManyToOne
		@JoinColumn(name="seed_id")
		private Seed seed;

		public Seed getSeed() {
			return seed;
		}

		public void setSeed(Seed seed) {
			this.seed = seed;
		}
		
}
