package com.projet.ferme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	Sale findBySubjectId(String subjectId);

}
