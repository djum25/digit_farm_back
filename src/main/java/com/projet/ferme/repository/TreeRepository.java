package com.projet.ferme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Tree;

public interface TreeRepository extends JpaRepository<Tree,Long>{

	int countByPresent(boolean b);

	Optional<Tree> findByName(String name);
	
	List<Tree> findByPresent(boolean b);

	List<Tree> findByPlanting_id(Long id);

	List<Tree> findByCategory_id(Long id);
}
