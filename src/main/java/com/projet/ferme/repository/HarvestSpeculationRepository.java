package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.HarvestSpeculation;

public interface HarvestSpeculationRepository extends JpaRepository<HarvestSpeculation,Long>{

	List<HarvestSpeculation> getBySpeculation_id(Long id);

}
