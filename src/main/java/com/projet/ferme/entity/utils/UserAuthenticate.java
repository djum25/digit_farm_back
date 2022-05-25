package com.projet.ferme.entity.utils;

import com.projet.ferme.entity.person.User;
import com.projet.ferme.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserAuthenticate {
	
	@Autowired
	private UserRepository repository;
	
	public User getAuthenticatetUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = repository.findByUsername(username).get();
		
		return user;
		
	}
}