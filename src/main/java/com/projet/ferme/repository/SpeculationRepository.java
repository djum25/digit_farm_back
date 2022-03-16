package com.projet.ferme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Speculation;

public interface SpeculationRepository extends JpaRepository<Speculation,Long>{

	int countByPresent(boolean b);
	
	Optional<Speculation> findByName(String name);
	
	List<Speculation> findByPresent(boolean present);

	List<Speculation> findByPlanting_id(Long id);

	List<Speculation> findBySeed_id(Long id);
}
