package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.calendars.CalendarySpeculation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarySpeculationRepository extends JpaRepository<CalendarySpeculation,Long>{

	List<CalendarySpeculation> getBySpeculation_id(Long id);

}
