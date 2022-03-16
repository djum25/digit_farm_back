package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.PoultryCalendaryMin;

public interface PoultryCalendaryMinRepository extends JpaRepository<PoultryCalendaryMin, Long>{

	List<PoultryCalendaryMin> findByCategoryId(Long id);

}
