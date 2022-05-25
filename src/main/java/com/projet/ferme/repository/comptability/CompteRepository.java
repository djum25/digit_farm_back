package com.projet.ferme.repository.comptability;

import java.util.Optional;

import com.projet.ferme.entity.comptability.Compte;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long>{
    
    Optional<Compte> findByNumber(String number);
}
