package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.OutgoingStock;

public interface OutgoingStockRepository extends JpaRepository<OutgoingStock, Long>{

	List<OutgoingStock> findByType(String type);
	
	List<OutgoingStock> findByProduit(String produit);
	
	List<OutgoingStock> findBySubjectId(String subjectId);
	
}
