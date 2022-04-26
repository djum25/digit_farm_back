package com.projet.ferme.repository;

import java.util.List;

import com.projet.ferme.entity.SecondaryCompte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SecondaryCompteRepository extends JpaRepository<SecondaryCompte, Long>{

    List<SecondaryCompte> findByPrimary_id(Long id);
    
}
