package com.projet.ferme.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.Seed;
import com.projet.ferme.service.SeedService;

@RestController
public class SeedController {

	@Autowired
	private SeedService service;
	
	@RequestMapping(value = "/api/v1/seed", method = RequestMethod.POST)
	public Map<String, Object> add(@RequestBody Seed S) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.add(S);
		
		return returnMap ; 
	}
	
	@RequestMapping(value = "/api/v1/seed", method = RequestMethod.PUT)
	public Map<String, Object> put(@RequestBody Seed S) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.put(S);
		
		return returnMap ; 
	}
	
	@RequestMapping(value = "/api/v1/seed", method = RequestMethod.GET)
	public Map<String, Object> get() {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.findAll();
		
		return returnMap ; 
	}
	
	@RequestMapping(value = "/api/v1/seed/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> delete(@PathVariable("id") Long id) {
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.delete(id);
		
		return returnMap ; 
	}
}
