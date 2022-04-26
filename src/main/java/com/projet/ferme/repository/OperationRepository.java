package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.Operation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long>{

    List<Operation> findBySecondary_id(Long id);
    
}
