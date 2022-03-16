package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.CalendarySpeculation;

public interface CalendarySpeculationRepository extends JpaRepository<CalendarySpeculation,Long>{

	List<CalendarySpeculation> getBySpeculation_id(Long id);

}
