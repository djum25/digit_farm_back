package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.outsubject.IncomingStock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomingStockRepository extends JpaRepository<IncomingStock, Long>{

	List<IncomingStock> findByType(String type);
}
