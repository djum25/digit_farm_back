package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.OutFish;

public interface OutFishRepository extends JpaRepository<OutFish, Long>{

	List<OutFish> findByFish_id(Long id);
}
