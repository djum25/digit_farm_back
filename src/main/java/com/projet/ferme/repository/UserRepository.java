package com.projet.ferme.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.ferme.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	//User findByUsernameAndPassword(String username, String password);

	//org.springframework.security.core.userdetails.User findByUsername(String username);
	
	 Optional<User> findByUsername(String username);

	//@PostMapping
	//List<User> findByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
