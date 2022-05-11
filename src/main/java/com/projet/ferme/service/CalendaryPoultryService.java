package com.projet.ferme.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.calendars.CalendaryPoultry;
import com.projet.ferme.entity.calendars.PoultryCalendaryMin;
import com.projet.ferme.entity.category.PoultryCategory;
import com.projet.ferme.entity.subject.Poultry;
import com.projet.ferme.repository.CalendaryPoultryRepository;
import com.projet.ferme.repository.PoultryCalendaryMinRepository;
import com.projet.ferme.repository.PoultryCategoryRepository;
import com.projet.ferme.repository.PoultryRepository;

@Service
public class CalendaryPoultryService {
	
	@Autowired
	private CalendaryPoultryRepository calendaryPoultryRepository;
	@Autowired
	private PoultryCalendaryMinRepository minRepository;
	@Autowired
	private PoultryCategoryRepository categoryRepository;
	@Autowired
	private PoultryRepository poultryRepository;
	
	public Map<String, Object> add(CalendaryPoultry newCalendar) {
		
		CalendaryPoultry calendaryPoultry =  calendaryPoultryRepository.save(newCalendar);
		
		Map<String,Object> returnValues = new HashMap<String,Object>();
		
		returnValues.put("success", true);
		returnValues.put("calendar",calendaryPoultry);
		
		return returnValues;
	}
	
	public Map<String, Object> findByPoultryId(Long id) {
		
		List<CalendaryPoultry> calendaryPoultry = calendaryPoultryRepository.findByPoultry_id(id);
		Poultry poultry = poultryRepository.findById(id).get();
		Map<String,Object> returnValues = new HashMap<String,Object>();
		
		returnValues.put("success", true);
		returnValues.put("calendars",calendaryPoultry);
		returnValues.put("poultry", poultry);
		
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
			returnValues.put("success", false);
			returnValues.put("minCalendar", minCalendar);
		}else {
			returnValues.put("success", true);
			returnValues.put("minCalendar", minCalendar);
			returnValues.put("category", minCalendar.getCategory());
		}
		return returnValues;
	}
	
	public Map<String, Object> deleteMin(Long id){
		Map<String, Object> returnValues = new HashMap<String, Object>();
		minRepository.deleteById(id);
		returnValues.put("success", true);
		returnValues.put("message", "Supprimer avec succé");
		
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
