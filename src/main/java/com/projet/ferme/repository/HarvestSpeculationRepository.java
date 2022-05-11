package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.outsubject.HarvestSpeculation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HarvestSpeculationRepository extends JpaRepository<HarvestSpeculation,Long>{

	List<HarvestSpeculation> getBySpeculation_id(Long id);

}
