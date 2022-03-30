package com.projet.ferme.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.CalendarFrequency;
import com.projet.ferme.entity.CalendaryPoultry;
import com.projet.ferme.entity.CalendarySpeculation;
import com.projet.ferme.entity.Poultry;
import com.projet.ferme.entity.PoultryCalendaryMin;
import com.projet.ferme.entity.Speculation;
import com.projet.ferme.entity.SpeculationCalendaryMin;
import com.projet.ferme.repository.CalendaryPoultryRepository;
import com.projet.ferme.repository.CalendarySpeculationRepository;
import com.projet.ferme.repository.PoultryCalendaryMinRepository;
import com.projet.ferme.repository.SpeculationCalendaryMinRepository;

@Service
public class CalendaryFrequencyService {

	@Autowired
	private CalendarySpeculationRepository calendarySpeculationRepository;
	@Autowired
	private CalendaryPoultryRepository calendaryPoultryRepository;
	@Autowired
	private SpeculationCalendaryMinRepository speculationCalendaryMinRepository;
	@Autowired
	private PoultryCalendaryMinRepository poultryCalendaryMinRepository;

	public Map<String, Object> addSpeculation(CalendarFrequency calendarFrequency) {
		
		Map<String, Object> map = new HashMap<String,Object>();
		Speculation speculation = calendarFrequency.getSpeculation();
		int number = (calendarFrequency.getEnd() - calendarFrequency.getStart())/calendarFrequency.getFrequence();
		java.util.Date date = new java.util.Date();
		Date sqlStartDate = new Date(date.getTime());
		int saved = 0;
		List<CalendarySpeculation> calendars= new ArrayList<CalendarySpeculation>();
		for (int i = 0; i <= number; i++) {
			
			int dayToAdd = (calendarFrequency.getFrequence() * i ) + calendarFrequency.getStart();
			CalendarySpeculation cal = new  CalendarySpeculation();
			Calendar c = Calendar.getInstance();
			c.setTime(speculation.getSeedDate());
			c.add(Calendar.DATE,dayToAdd);
			cal.setSpeculation(speculation);
			cal.setCalendaryName(calendarFrequency.getCalendaryName());
			Date x = new Date(c.getTimeInMillis());
			cal.setDate(x);
			cal.setCreatedOn(sqlStartDate);
			cal.setIntervention(calendarFrequency.getIntervention());
			cal.setMake(false);
			cal.setUpdatedOn(null);
			cal.setId(null);
			
			CalendarySpeculation resultCalendarySpeculation =  calendarySpeculationRepository.save(cal);
			if (resultCalendarySpeculation != null) {
				calendars.add(resultCalendarySpeculation);
				saved++;
			}
		}
		
		map.put("success", true);
		map.put("message", saved+" sont enregistrés");
		map.put("calendars", calendars);
		
		return map;
	}
	
	public Map<String, Object> addPoultry(CalendarFrequency calendarFrequency){
		
		Map<String, Object> map = new HashMap<String,Object>();
		Poultry poultry = calendarFrequency.getPoultry();
		int number = (calendarFrequency.getEnd() - calendarFrequency.getStart())/calendarFrequency.getFrequence();
		java.util.Date date = new java.util.Date();
		Date sqlStartDate = new Date(date.getTime());
		int saved = 0;
		List<CalendaryPoultry> calendars= new ArrayList<CalendaryPoultry>();
		for (int i = 0; i <= number; i++) {
			
			int dayToAdd = (calendarFrequency.getFrequence() * i) + calendarFrequency.getStart() ;
			CalendaryPoultry cal = new  CalendaryPoultry();
			Calendar c = Calendar.getInstance();
			c.setTime(poultry.getDateOfEntry());
			c.add(Calendar.DATE,dayToAdd);
			cal.setPoultry(poultry);
			cal.setCalendaryName(calendarFrequency.getCalendaryName());
			Date x = new Date(c.getTimeInMillis());
			cal.setDate(x);
			cal.setCreatedOn(sqlStartDate);
			cal.setIntervention(calendarFrequency.getIntervention());
			cal.setMake(false);
			cal.setUpdatedOn(null);
			cal.setId(null);
			
			CalendaryPoultry resultCalendarySpeculation =  calendaryPoultryRepository.save(cal);
			if (resultCalendarySpeculation != null) {
				calendars.add(resultCalendarySpeculation);
				saved++;
			}
		}
		
		map.put("success", true);
		map.put("message", saved+" sont enregistrés");
		map.put("calendars", calendars);
		
		return map;
	}
	
	public Map<String, Object> addSeedCalendarFrequence(CalendarFrequency calendarFrequency) {
	
		Map<String, Object> map = new HashMap<String, Object>();
		int number = (calendarFrequency.getEnd() - calendarFrequency.getStart())/calendarFrequency.getFrequence();
		java.util.Date date = new java.util.Date();
		Date sqlStartDate = new Date(date.getTime());
		int saved = 0;
		List<SpeculationCalendaryMin> mins = new ArrayList<SpeculationCalendaryMin>();
		for (int i = 0; i <= number; i++) {
			int dayToAdd = (calendarFrequency.getFrequence() * i) + calendarFrequency.getStart() ;
			SpeculationCalendaryMin min = new SpeculationCalendaryMin();
			min.setIntervention(calendarFrequency.getIntervention());
			min.setName(calendarFrequency.getCalendaryName());
			min.setOld(dayToAdd);
			min.setSeed(calendarFrequency.getSeed());
			min.setCreatedOn(sqlStartDate);
			min.setUpdatedOn(sqlStartDate);
			
			SpeculationCalendaryMin savedMin = speculationCalendaryMinRepository.save(min);
			if (savedMin != null) {
				mins.add(savedMin);
				saved++;
			}
			
		}
		
		map.put("success", true);
		map.put("message", saved+" sont enregistrés");
		map.put("calendars", mins);
		
		return map;
	}
	
	public Map<String, Object> addCategoryPoultryMin(CalendarFrequency calendarFrequency) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		int number = (calendarFrequency.getEnd() - calendarFrequency.getStart())/calendarFrequency.getFrequence();
		java.util.Date date = new java.util.Date();
		Date sqlStartDate = new Date(date.getTime());
		int saved = 0;
		List<PoultryCalendaryMin> mins = new ArrayList<PoultryCalendaryMin>();
		for (int i = 0; i <= number; i++) {
			int dayToAdd = (calendarFrequency.getFrequence() * i) + calendarFrequency.getStart() ;
			PoultryCalendaryMin min = new PoultryCalendaryMin();
			min.setIntervention(calendarFrequency.getIntervention());
			min.setName(calendarFrequency.getCalendaryName());
			min.setOld(dayToAdd);
			min.setCategory(calendarFrequency.getPoultryCategory());
			min.setCreatedOn(sqlStartDate);
			min.setUpdatedOn(sqlStartDate);
			
			PoultryCalendaryMin savedMin = poultryCalendaryMinRepository.save(min);
			if (savedMin != null) {
				mins.add(savedMin);
				saved++;
			}
		}
		
		map.put("success", true);
		map.put("message", saved+" sont enregistrés");
		map.put("calendars", mins);
		
		return map;
	}
}
