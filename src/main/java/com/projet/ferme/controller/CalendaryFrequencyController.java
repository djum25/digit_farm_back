package com.projet.ferme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.CalendarFrequency;
import com.projet.ferme.service.CalendaryFrequencyService;

@RestController
public class CalendaryFrequencyController {

	@Autowired
	private CalendaryFrequencyService service;
	
	@RequestMapping(value = "/api/v1/frequence/calendar/speculation", method = RequestMethod.POST)
	public Map<String, Object> postCalendarSpeculation(@RequestBody CalendarFrequency cal) {
		return service.addSpeculation(cal);
	}
	
	@RequestMapping(value = "/api/v1/frequence/calendar/poultry", method = RequestMethod.POST)
	public Map<String, Object> postCalendarPoultry(@RequestBody CalendarFrequency cal){
		return service.addPoultry(cal);
	}
}
