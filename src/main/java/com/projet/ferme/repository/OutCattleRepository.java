package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.OutCattle;

public interface OutCattleRepository extends JpaRepository<OutCattle,Long>{

	List<OutCattle> getByCattle_id(Long id);

}
