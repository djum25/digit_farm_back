package com.projet.ferme.repository;

import com.projet.ferme.entity.stocks.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	Sale findBySubjectId(String subjectId);

}
