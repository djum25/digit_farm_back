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
	
	@RequestMapping(value = "/api/v1/frequence/calendar/seed", method = RequestMethod.POST)
	public Map<String, Object> postSeedFrequence(@RequestBody CalendarFrequency cal){
		return service.addSeedCalendarFrequence(cal);
	}
	
	@RequestMapping(value = "/api/v1/frequence/calendar/category/poultry", method = RequestMethod.POST)
	public Map<String, Object> postCategoryPoultry(@RequestBody CalendarFrequency cal){
		return service.addCategoryPoultryMin(cal);
	}	
	
	@RequestMapping(value = "/api/v1/frequence/calendar/category/tree", method = RequestMethod.POST)
	public Map<String, Object> postCategoryTree(@RequestBody CalendarFrequency cal){
		return service.addCategoryTreeMin(cal);
	}
	
	@RequestMapping(value = "/api/v1/frequence/calendar/category/fish", method = RequestMethod.POST)
	public Map<String, Object> postCategorfish(@RequestBody CalendarFrequency cal){
		return service.addCategoryFishMin(cal);
	}
	
	@RequestMapping(value = "/api/v1/frequence/calendar/category/cattle", method = RequestMethod.POST)
	public Map<String, Object> postCategoryCattle(@RequestBody CalendarFrequency cal){
		return service.addCategoryCattleMin(cal);
	}
}
