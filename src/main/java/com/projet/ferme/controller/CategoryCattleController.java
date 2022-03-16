package com.projet.ferme.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.CattleCategory;
import com.projet.ferme.service.CategoryCattleService;

@RestController
public class CategoryCattleController {

	@Autowired
	private CategoryCattleService service;
	
	@RequestMapping(value = "/api/v1/cattleCategory", method = RequestMethod.POST)
	public Map<String, Object> post(@RequestBody CattleCategory C) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.add(C);
		return returnMap;
	}
	
	@RequestMapping(value = "/api/v1/cattleCategory", method = RequestMethod.PUT)
	public Map<String, Object> put(@RequestBody CattleCategory C) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.add(C);
		return returnMap;
	}
	
	@RequestMapping(value = "/api/v1/cattleCategory", method = RequestMethod.GET)
	public Map<String, Object> get() {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.findAll();
		return returnMap;
	}
	
	@RequestMapping(value = "/api/v1/cattleCategory/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> post(@PathVariable("id") Long id) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap = service.delete(id);
		return returnMap;
	}
}
