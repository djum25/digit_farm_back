package com.projet.ferme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projet.ferme.entity.FishCategory;
@CrossOrigin("*")
public interface FishCategoryRepository extends JpaRepository<FishCategory, Long>{

}
