package com.projet.ferme.repository;

import com.projet.ferme.entity.Compte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long>{
    
}
