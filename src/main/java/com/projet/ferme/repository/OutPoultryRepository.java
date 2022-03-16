package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.OutPoultry;

public interface OutPoultryRepository extends JpaRepository<OutPoultry,Long>{

	List<OutPoultry> findByPoultry_id(Long id);

}
