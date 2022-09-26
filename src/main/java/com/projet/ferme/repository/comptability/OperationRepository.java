package com.projet.ferme.repository.comptability;

import java.util.List;

import com.projet.ferme.entity.comptability.Operation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long>{

    List<Operation> findByCompte_id(Long id);

    List<Operation> findByCategory_id(Long id);

    List<Operation> findAll();

    
}