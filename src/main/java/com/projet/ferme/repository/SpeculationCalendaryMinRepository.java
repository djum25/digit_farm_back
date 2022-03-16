package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.SpeculationCalendaryMin;

public interface SpeculationCalendaryMinRepository extends JpaRepository<SpeculationCalendaryMin, Long>{

	List<SpeculationCalendaryMin> findBySeedId(Long id);

}
