package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.CalendaryFish;

public interface CalendaryFishRepository extends JpaRepository<CalendaryFish, Long>{

	List<CalendaryFish> findByFish_id(Long id);

}
