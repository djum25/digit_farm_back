package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.FishCalendaryMin;

public interface FishCalendaryMinRepository extends JpaRepository<FishCalendaryMin,Long>{

	List<FishCalendaryMin> findByCategoryId(Long id);
}
