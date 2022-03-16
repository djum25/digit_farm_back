package com.projet.ferme.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.CalendaryPoultry;
import com.projet.ferme.entity.PoultryCalendaryMin;
import com.projet.ferme.entity.PoultryCategory;
import com.projet.ferme.repository.CalendaryPoultryRepository;
import com.projet.ferme.repository.PoultryCalendaryMinRepository;
import com.projet.ferme.repository.PoultryCategoryRepository;

@Service
public class CalendaryPoultryService {
	
	@Autowired
	private CalendaryPoultryRepository calendaryPoultryRepository;
	@Autowired
	private PoultryCalendaryMinRepository minRepository;
	@Autowired
	private PoultryCategoryRepository categoryRepository;
	
	public Map<String, Object> add(CalendaryPoultry newCalendar) {
		
		CalendaryPoultry calendaryPoultry =  calendaryPoultryRepository.save(newCalendar);
		
		Map<String,Object> returnValues = new HashMap<String,Object>();
		
		returnValues.put("success", true);
		returnValues.put("calendar",calendaryPoultry);
		
		return returnValues;
	}
	
	public Map<String, Object> findByPoultryId(Long id) {
		
		List<CalendaryPoultry> calendaryPoultry = calendaryPoultryRepository.findByPoultry_id(id);
		
		Map<String,Object> returnValues = new HashMap<String,Object>();
		
		returnValues.put("success", true);
		returnValues.put("calendars",calendaryPoultry);
		
		return returnValues;
	}
	
	public Map<String, Object> put(CalendaryPoultry calendaryPoultry){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		CalendaryPoultry calendar = calendaryPoultryRepository.save(calendaryPoultry);
		returnValues.put("success", true);
		returnValues.put("calendar",calendar);
		
		return returnValues;
	}
	
	public Map<String, Object> delete(Long id){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		calendaryPoultryRepository.deleteById(id);
		returnValues.put("success", true);
		return returnValues;
	}
	
	public Map<String, Object> addMin(PoultryCalendaryMin min) {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		PoultryCalendaryMin minCalendar = minRepository.save(min);
		
		if(minCalendar == null) {
			returnValues.put("succes", false);
			returnValues.put("minCalendar", minCalendar);
		}else {
			returnValues.put("succes", true);
			returnValues.put("minCalendar", minCalendar);
			returnValues.put("category", minCalendar.getCategory());
		}
		return returnValues;
	}
	
	public Map<String, Object> deleteMin(Long id){
		Map<String, Object> returnValues = new HashMap<String, Object>();
		minRepository.deleteById(id);
		return returnValues;
	}
	
	public Map<String, Object> makeTrue(Long id) {
		
		Map<String, Object> returnValues = new HashMap<String,Object>();
		CalendaryPoultry calendary =  calendaryPoultryRepository.getById(id);
		
		if(calendary == null) {
			returnValues.put("success", false);
			returnValues.put("message", "Enregistrement introuvable");
		}else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			calendary.setUpdatedOn(sqlStartDate);
			calendary.setMake(true);
			calendary = calendaryPoultryRepository.save(calendary);
			returnValues.put("success", true);
			returnValues.put("message", "Enregistrement réussi");
		}
		
		return returnValues;
	}
	
	public Map<String, Object> findByCategory(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PoultryCalendaryMin> calendaryMins = minRepository.findByCategoryId(id);
		PoultryCategory category = categoryRepository.findById(id).get();
		
		map.put("success", true);
		map.put("calendaryMins", calendaryMins);
		map.put("category",category);
		
		return map;
	}
}
