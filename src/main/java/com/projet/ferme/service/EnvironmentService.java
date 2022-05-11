package com.projet.ferme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.person.User;
import com.projet.ferme.repository.UserRepository;

@Service
public class EnvironmentService {
	
	@Autowired
	private UserRepository repository;
	
	public User getRequestUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = repository.findByUsername(username).get();
		
		return user;
		
	}
}
