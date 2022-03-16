package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.CalendaryPoultry;

public interface CalendaryPoultryRepository extends JpaRepository<CalendaryPoultry,Long>{

	List<CalendaryPoultry> findByPoultry_id(Long id);

}
