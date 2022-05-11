package com.projet.ferme.repository;

import com.projet.ferme.entity.category.CattleCategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
public interface CattleCategoryRepository extends JpaRepository<CattleCategory, Long>{

}
