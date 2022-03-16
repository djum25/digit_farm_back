package com.projet.ferme.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.CalendarySpeculation;
import com.projet.ferme.entity.Seed;
import com.projet.ferme.entity.SpeculationCalendaryMin;
import com.projet.ferme.repository.CalendarySpeculationRepository;
import com.projet.ferme.repository.SeedRepository;
import com.projet.ferme.repository.SpeculationCalendaryMinRepository;

@Service
public class CalendarySpeculationService {

	@Autowired
	private CalendarySpeculationRepository calerendaryFarmingRepository;
	@Autowired
	private SpeculationCalendaryMinRepository minRepository;
	@Autowired
	private SeedRepository seedRepository;
	
	
	public Map<String, Object> add(CalendarySpeculation calendaryFarming){
		
		CalendarySpeculation newCalendaryFarming = calerendaryFarmingRepository.save(calendaryFarming);
		Map<String, Object> returnValues = new HashMap<String,Object>();
		
		if(newCalendaryFarming == null) {
			returnValues.put("success", false);
			returnValues.put("calendar", newCalendaryFarming);
		}else {
				returnValues.put("success", true);
				returnValues.put("calendar", newCalendaryFarming);
		}
		
		return returnValues;
	}
	
	public Map<String, Object> findBySpeculationId(Long id){
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		List <CalendarySpeculation> calendars = calerendaryFarmingRepository.getBySpeculation_id(id);
		returnValues.put("calendars", calendars);
		
		return returnValues;
		
	}
	
	public Map<String, Object> put(CalendarySpeculation calendaryFarming){
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		CalendarySpeculation newCalendaryFarming = calerendaryFarmingRepository.save(calendaryFarming);
		
		returnValues.put("success", true);
		returnValues.put("calendar", newCalendaryFarming);
		
		return returnValues;
	}
	
	public Map<String, Object> makeTrue(Long id) {
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		CalendarySpeculation calendarySpeculation =  calerendaryFarmingRepository.getById(id);
		
		if(calendarySpeculation == null) {
			returnValues.put("success", false);
			returnValues.put("message", "Enregistrement introuvable");
		}else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			calendarySpeculation.setUpdatedOn(sqlStartDate);
			calendarySpeculation.setMake(true);
			calendarySpeculation = calerendaryFarmingRepository.save(calendarySpeculation);
			returnValues.put("success", true);
			returnValues.put("message", "Enregistrement réussi");
		}
		
		return returnValues;
	}
	
	public Map<String, Object> giveUpTrue(CalendarySpeculation cal) {
		Map<String, Object> map = new HashMap<String, Object>();
		CalendarySpeculation oldCalendarySpeculation = calerendaryFarmingRepository.getById(cal.getId());
		if(oldCalendarySpeculation == null) {
			map.put("success", false);
			map.put("message", "Ce programme est supprimé");
		}else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			oldCalendarySpeculation.setGiveUp(true);
			oldCalendarySpeculation.setDescription(cal.getDescription());
			oldCalendarySpeculation.setUpdatedOn(sqlStartDate);
			calerendaryFarmingRepository.save(oldCalendarySpeculation);
			map.put("success", true);
			map.put("message", "Modofier avec succé");
		}
		return map;
	}
	
	public Map<String, Object> delete(Long id){
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		calerendaryFarmingRepository.deleteById(id);
		returnValues.put("success", true);
		return returnValues;
	}
	
	public Map<String, Object> addMin(SpeculationCalendaryMin min){
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		SpeculationCalendaryMin minCalendar = minRepository.save(min);
		
		if(minCalendar == null) {
			returnValues.put("success", false);
			returnValues.put("minCalendar", minCalendar);
		}else {

			returnValues.put("success", true);
			returnValues.put("minCalendar", minCalendar);
			returnValues.put("seed", minCalendar.getSeed());
		}
		
		return returnValues;
	}
	
	public Map<String, Object> deleteMin(Long id){
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		minRepository.deleteById(id);
		return returnValues;
	}
	
	public Map<String, Object> findBySeed(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<SpeculationCalendaryMin> calendaryMins = minRepository.findBySeedId(id);
		Seed seed = seedRepository.findById(id).get();
		
		map.put("success", true);
		map.put("calendaryMins", calendaryMins);
		map.put("seed", seed);
		
		return map;
	}
		
}
	
