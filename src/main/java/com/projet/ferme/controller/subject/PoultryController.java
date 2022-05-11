package com.projet.ferme.controller.subject;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.outsubject.OutPoultry;
import com.projet.ferme.entity.subject.Poultry;
import com.projet.ferme.service.homesubject.ChickenCoopService;
import com.projet.ferme.service.outsubject.OutPoultryService;
import com.projet.ferme.service.subject.PoultryService;

@RestController
public class PoultryController {

	@Autowired
	private PoultryService poutryService;
	@Autowired
	private ChickenCoopService coopService;
	@Autowired
	private OutPoultryService outPoultryService;
	
	@RequestMapping(value="/api/v1/poultry", method=RequestMethod.POST)
	public Map<String, Object> addPoultry(@RequestBody Poultry poultry){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.add(poultry);
		
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/poultry",method=RequestMethod.PUT)
	public Map<String, Object> putPoultry(@RequestBody Poultry poultry){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.put(poultry);
		
		return returnValues;
	}
	
	// I never use this route to delete use /api/v1/poultrys/{id}
	@RequestMapping(value="/api/v1/poultry/{id}",method=RequestMethod.DELETE)
	public Map<String, Object> deletePoultry(@PathVariable("id") Long id){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.delete(id);
		
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/category/poultry/{id}",method=RequestMethod.GET)
	public Map<String, Object> getPoultry(@PathVariable("id") Long id){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.findByCategory(id);
		
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/coop/poultry/{id}",method=RequestMethod.GET)
	public Map<String, Object> getPoultryByCoop(@PathVariable("id") Long id){
		return poutryService.findByCoop(id);
	}
	
	@RequestMapping(value="/api/v1/poultry/byName",method=RequestMethod.GET)
	public Map<String, Object> getPoultry(@RequestParam String name){

		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.findByName(name);
		
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/poultry/byPresent",method=RequestMethod.GET)
	public Map<String, Object> getPoultry(@RequestParam Boolean present){

		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.findByPresent(present);
		
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/coop",method=RequestMethod.GET)
	public Map<String, Object> coop(){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = coopService.findAllFree();
		return returnValues;
	}
	
	@RequestMapping(value="/api/v1/poultry/count",method=RequestMethod.GET)
	public Map<String, Object> countPoultry(){
		
		Map<String,Object> returnValues = new HashMap<String, Object>();
		returnValues = poutryService.count();
		
		return returnValues;
	}
	
	@RequestMapping(value = "/api/v1/outPoultry/{id}", method = RequestMethod.GET)
	public Map<String, Object> findOut(@PathVariable("id") Long id){
		return outPoultryService.findByPoultry(id);
	}
	
	@RequestMapping(value = "/api/v1/outPoultry", method = RequestMethod.POST)
	public Map<String, Object> addOut(@RequestBody OutPoultry out){
		return outPoultryService.add(out);
	}
	
	@RequestMapping(value = "/api/v1/outPoultry", method = RequestMethod.PUT)
	public Map<String, Object> putOut(@RequestBody OutPoultry out){
		return outPoultryService.put(out);
	}
	
	@RequestMapping(value = "/api/v1/outPoultry/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteOut(@PathVariable("id") Long id){
		return outPoultryService.delete(id);
	}
	
}
