package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Egg;

public interface EggRepository extends JpaRepository<Egg, Long>{

	List<Egg> findByPoultry_id(Long id);
}
