package com.projet.ferme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.ShopStock;

public interface ShopStockRepository extends JpaRepository<ShopStock, Long>{

	List<ShopStock> findByProduct(String product);

	List<ShopStock> findByShop_id(Long shopId);

}
