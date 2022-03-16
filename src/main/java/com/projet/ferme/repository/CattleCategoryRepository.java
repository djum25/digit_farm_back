package com.projet.ferme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projet.ferme.entity.CattleCategory;

@CrossOrigin("*")
public interface CattleCategoryRepository extends JpaRepository<CattleCategory, Long>{

}
