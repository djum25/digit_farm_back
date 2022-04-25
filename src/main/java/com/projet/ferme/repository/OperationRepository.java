package com.projet.ferme.repository;

import com.projet.ferme.entity.Operation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long>{
    
}
