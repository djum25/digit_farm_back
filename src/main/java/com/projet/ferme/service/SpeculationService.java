package com.projet.ferme.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.CalendarySpeculation;
import com.projet.ferme.entity.Planting;
import com.projet.ferme.entity.Seed;
import com.projet.ferme.entity.Speculation;
import com.projet.ferme.entity.SpeculationCalendaryMin;
import com.projet.ferme.repository.CalendarySpeculationRepository;
import com.projet.ferme.repository.SpeculationCalendaryMinRepository;
import com.projet.ferme.repository.SpeculationRepository;

@Service
public class SpeculationService {

	@Autowired
	private SpeculationRepository farmingRepository;
	@Autowired
	private SpeculationCalendaryMinRepository minRepository;
	@Autowired
	private CalendarySpeculationRepository calendarySpeculationRepository;
	@Autowired
	private PlantingService plantingService;
	@Autowired
	private MatriculeService matricule;
	@Autowired
	private SeedService seedService;
	
	public Map<String, Object> add(Speculation speculation) {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		speculation.setName(matricule.getName(speculation.getSeed().getSeedName()));
		Speculation newFarming = farmingRepository.save(speculation);
		
		if(newFarming == null){
			returnValues.put("success", false);
			returnValues.put("speculation", newFarming);
		}else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			List<SpeculationCalendaryMin> mins = minRepository.findBySeedId(newFarming.getSeed().getId());
			for(SpeculationCalendaryMin min: mins) {
				CalendarySpeculation cal = new  CalendarySpeculation();
				Calendar c = Calendar.getInstance();
				c.setTime(newFarming.getSeedDate());
				c.add(Calendar.DATE,min.getOld());
				cal.setSpeculation(newFarming);
				cal.setCalendaryName(min.getName());
				Date x = new Date(c.getTimeInMillis());
				cal.setDate(x);
				cal.setCreatedOn(sqlStartDate);
				cal.setIntervention(min.getIntervention());
				cal.setMake(false);
				cal.setUpdatedOn(null);
				cal.setId(null);
				
				calendarySpeculationRepository.save(cal);
				
				plantingService.isNotFree(newFarming.getPlanting());
				
			}
			returnValues.put("success", true);
			returnValues.put("speculation", newFarming);
		}
		
		return returnValues;
	}
	
	public Map<String, Object> findAll() {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		List<Speculation> farmings = farmingRepository.findAll();
		
		returnValues.put("success", true);
		returnValues.put("speculation", farmings);
		
		return returnValues;
	}
	
	public Map<String, Object> findByName(String name){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		Optional<Speculation> speculation = farmingRepository.findByName(name) ;
		
		if(speculation == null) {
			returnValues.put("success", false);
			returnValues.put("speculation", speculation);
		}else {
			returnValues.put("success", true);
			returnValues.put("speculation", speculation);
		}
			
		return returnValues;
	}
	
	public Map<String, Object> findByPresent(boolean b){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		List<Speculation> speculations = farmingRepository.findByPresent(b) ;
		
			returnValues.put("success", true);
			returnValues.put("speculations", speculations);
			
			return returnValues;
	}
	
	public Map<String, Object> findByPlanting(Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Speculation> speculations = farmingRepository.findByPlanting_id(id);
		Planting planting = plantingService.findById(id);
		map.put("success", true);
		map.put("planting", planting);
		map.put("speculations", speculations);
		
		return map;
	}
	
	public Map<String, Object> findBySeed(Long id){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Speculation> speculations = farmingRepository.findBySeed_id(id);
		Seed seed = seedService.findById(id);
		map.put("success", true);
		map.put("seed", seed);
		map.put("speculations", speculations);
		
		return map;
	}
	
	public Map<String, Object> put(Speculation speculation) {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		Speculation newFarming = farmingRepository.save(speculation);
		
		if(newFarming == null){
			returnValues.put("success", false);
			returnValues.put("speculation", newFarming);
		}else {
			returnValues.put("success", true);
			returnValues.put("speculation", newFarming);
		}
		
		return returnValues;
	}
	
	public Map<String, Object> delete(Long id) {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		farmingRepository.deleteById(id);
		returnValues.put("success", true);		
		return returnValues;
	}
	
	public Map<String, Object> count() {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		
		int isPresent = farmingRepository.countByPresent(true);
		int isMissing = farmingRepository.countByPresent(false);
		
		returnValues.put("success", true);
		returnValues.put("present", isPresent);
		returnValues.put("missing",isMissing);
		
		return returnValues;
	}
}
