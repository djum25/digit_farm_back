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
import com.projet.ferme.entity.Speculation;
import com.projet.ferme.repository.CalendaryPoultryRepository;
import com.projet.ferme.repository.CalendarySpeculationRepository;

@Service
public class CalendaryFrequencyService {

	@Autowired
	private CalendarySpeculationRepository calendarySpeculationRepository;
	@Autowired
	private CalendaryPoultryRepository calendaryPoultryRepository;
	
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
			cal.setCalendaryName(calendarFrequency.getName());
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
			cal.setCalendaryName(calendarFrequency.getName());
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
}
