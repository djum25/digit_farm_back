package com.projet.ferme.repository.comptability;

import com.projet.ferme.entity.comptability.Compte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long>{
    
}