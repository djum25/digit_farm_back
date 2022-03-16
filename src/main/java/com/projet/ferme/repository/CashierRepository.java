package com.projet.ferme.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.Cashier;

public interface CashierRepository extends JpaRepository<Cashier, Long>{

	Optional<Cashier> findByUser_idAndShop_id(Long id, Long id2);

	List<Cashier> findByShop_id(Long id);

}
