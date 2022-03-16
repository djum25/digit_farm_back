package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.TreeCalendaryMin;

public interface TreeCalendaryMinRepository extends JpaRepository<TreeCalendaryMin, Long>{

	List<TreeCalendaryMin> findByCategoryId(Long id);

}
