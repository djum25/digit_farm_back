package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.IncomingStock;

public interface IncomingStockRepository extends JpaRepository<IncomingStock, Long>{

	List<IncomingStock> findByType(String type);
}
