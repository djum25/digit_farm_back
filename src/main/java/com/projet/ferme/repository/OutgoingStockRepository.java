package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.stocks.OutgoingStock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OutgoingStockRepository extends JpaRepository<OutgoingStock, Long>{

	List<OutgoingStock> findByType(String type);
	
	List<OutgoingStock> findByProduit(String produit);
	
	List<OutgoingStock> findBySubjectId(String subjectId);
	
}
