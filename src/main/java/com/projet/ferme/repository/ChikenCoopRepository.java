package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projet.ferme.entity.ChickenCoop;

@CrossOrigin("*")
public interface ChikenCoopRepository extends JpaRepository<ChickenCoop,Long>{

	List<ChickenCoop> findByFree(boolean b);

}
