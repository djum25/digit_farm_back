package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.CalendaryTree;

public interface CalendaryTreeRepository extends JpaRepository<CalendaryTree, Long>{

	List<CalendaryTree> findByTree_id(Long id);

}
