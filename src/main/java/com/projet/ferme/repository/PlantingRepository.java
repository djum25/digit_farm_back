package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Planting;

public interface PlantingRepository extends JpaRepository<Planting, Long>{

	List<Planting> findByFree(boolean b);

}
