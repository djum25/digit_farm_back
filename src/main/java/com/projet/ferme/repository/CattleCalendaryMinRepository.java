package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.CattleCalendaryMin;

public interface CattleCalendaryMinRepository extends JpaRepository<CattleCalendaryMin, Long>{

	List<CattleCalendaryMin> findByCategoryId(Long id);
}
