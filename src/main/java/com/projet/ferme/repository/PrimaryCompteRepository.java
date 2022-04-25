package com.projet.ferme.repository;

import com.projet.ferme.entity.PrimaryCompte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrimaryCompteRepository extends JpaRepository<PrimaryCompte, Long> {
    
}
