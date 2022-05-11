package com.projet.ferme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.subject.Tree;
import com.projet.ferme.service.subject.TreeService;

@RestController
public class TreeController {

	@Autowired
	private TreeService treeService;
	
	@RequestMapping(value="/api/v1/tree", method=RequestMethod.POST)
	public Map<String, Object> addTree(@RequestBody Tree tree){
		return treeService.add(tree);
	}
	
	@RequestMapping(value="/api/v1/tree", method=RequestMethod.PUT)
	public Map<String, Object> putTree(@RequestBody Tree tree){
		return treeService.put(tree);
	}
	
	@RequestMapping(value="/api/v1/tree", method=RequestMethod.GET)
	public Map<String, Object> gerTree(){
		return treeService.findAll();
	}
	
	@RequestMapping(value="/api/v1/tree/byName", method=RequestMethod.GET)
	public Map<String, Object> gerTreeByName(@RequestParam String name){
		return treeService.findByName(name);
	}
	
	@RequestMapping(value = "/api/v1/planting/tree/{id}", method = RequestMethod.GET)
	public Map<String, Object> treeByPlantingId(@PathVariable("id") Long id){
		return treeService.findByPlantings(id);
	}
	
	@RequestMapping(value = "/api/v1/category/tree/{id}", method = RequestMethod.GET)
	public Map<String, Object> treeByCategoryId(@PathVariable("id") Long id){
		return treeService.findByCategory(id);
	}
	
	@RequestMapping(value="/api/v1/tree/byPresent", method=RequestMethod.GET)
	public Map<String, Object> gerTreeByPresent(@RequestParam boolean present){
		return treeService.findByPresent(present);
	}
	
	// Never use this route to delete use /api/v1/trees
	@RequestMapping(value="/api/v1/tree/{id}", method=RequestMethod.DELETE)
	public Map<String, Object>deleteTree(@PathVariable("id") Long id){
		return treeService.delete(id);
	}
	
	@RequestMapping(value="/api/v1/tree/count", method=RequestMethod.GET)
	public Map<String, Object> countTree(){
		return treeService.count();
	}
}
