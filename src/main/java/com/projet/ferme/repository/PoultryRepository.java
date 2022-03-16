package com.projet.ferme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.projet.ferme.entity.Poultry;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel="poultrys", path="poultrys")
public interface PoultryRepository extends JpaRepository<Poultry,Long>{

	int countByPresent(boolean b);
	
	Optional<Poultry>  findByName(String name);
	
	List<Poultry> findByPresent(Boolean present);

	List<Poultry> findByCategory_id(Long id);

	List<Poultry> ChickenCoop_id(Long id);
}
