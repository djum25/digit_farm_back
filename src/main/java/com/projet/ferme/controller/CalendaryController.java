package com.projet.ferme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.CalendaryCattle;
import com.projet.ferme.entity.CalendaryFish;
import com.projet.ferme.entity.CalendaryPoultry;
import com.projet.ferme.entity.CalendarySpeculation;
import com.projet.ferme.entity.CalendaryTree;
import com.projet.ferme.entity.CattleCalendaryMin;
import com.projet.ferme.entity.FishCalendaryMin;
import com.projet.ferme.entity.PoultryCalendaryMin;
import com.projet.ferme.entity.SpeculationCalendaryMin;
import com.projet.ferme.entity.TreeCalendaryMin;
import com.projet.ferme.service.CalendaryCattleService;
import com.projet.ferme.service.CalendaryFishService;
import com.projet.ferme.service.CalendaryPoultryService;
import com.projet.ferme.service.CalendarySpeculationService;
import com.projet.ferme.service.CalendaryTreeService;

@RestController
public class CalendaryController {

	@Autowired
	private CalendarySpeculationService calendarySpeculationService;
	@Autowired
	private CalendaryCattleService calendaryCattleService;	
	@Autowired
	private CalendaryFishService calendaryFishService;
	@Autowired
	private CalendaryPoultryService calendaryPoultryService;
	@Autowired
	private CalendaryTreeService calendaryTreeService;
	
	@RequestMapping(value = "/api/v1/add/calendar/speculation",method = RequestMethod.POST)
	public Map<String, Object> addCalendarySpeculation(@RequestBody CalendarySpeculation calendar){
		return calendarySpeculationService.add(calendar);
	}
	
	@RequestMapping(value="/api/v1/calendar/speculation/{id}",method=RequestMethod.GET)
	public Map<String, Object> getCalendarySpeculation(@PathVariable("id") Long id) {
		return calendarySpeculationService.findBySpeculationId(id);
	  }
	
	@RequestMapping(value = "/api/v1/add/calendar/cattle",method = RequestMethod.POST)
	public Map<String, Object> addCalendaryCattle(@RequestBody CalendaryCattle calendar){
		return calendaryCattleService.add(calendar);
	}
	
	@RequestMapping(value="/api/v1/calendar/cattle/{id}",method=RequestMethod.GET)
	public Map<String, Object> getCalendaryCattle(@PathVariable("id") Long id) {
		return calendaryCattleService.findByCatteId(id);
	  }
	
	@RequestMapping(value = "/api/v1/add/calendar/fish",method = RequestMethod.POST)
	public Map<String, Object> addCalendaryCattle(@RequestBody CalendaryFish cal){
		return calendaryFishService.add(cal);
	}
	
	@RequestMapping(value="/api/v1/calendar/fish/{id}",method=RequestMethod.GET)
	public Map<String, Object> getCalendaryFish(@PathVariable("id") Long id) {
		return calendaryFishService.findByFish(id);
	  }
	
	@RequestMapping(value = "/api/v1/add/calendar/poultry",method = RequestMethod.POST)
	public Map<String, Object> addCalendaryPoultry(@RequestBody CalendaryPoultry calendar){
		return calendaryPoultryService.add(calendar);
	}	
	
	@RequestMapping(value="/api/v1/calendar/poultry/{id}",method=RequestMethod.GET)
	public Map<String, Object> getCalendaryPoultry(@PathVariable("id") Long id) {
		return calendaryPoultryService.findByPoultryId(id);
	  }
	
	@RequestMapping(value = "/api/v1/add/calendar/tree",method = RequestMethod.POST)
	public Map<String, Object> addCalendaryTree(@RequestBody CalendaryTree cal){
		return calendaryTreeService.add(cal);
	}
	
	@RequestMapping(value="/api/v1/calendar/tree/{id}",method=RequestMethod.GET)
	public Map<String, Object> getCalendaryTree(@PathVariable("id") Long id) {
		return calendaryTreeService.findByTreeId(id);
	  }
	
	@RequestMapping(value="/api/v1/min/calendar/cattle",method=RequestMethod.POST)
	public Map<String, Object>  addMinCalendaryCattle(@RequestBody CattleCalendaryMin min){
		return calendaryCattleService.addMin(min);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/cattle/{id}",method=RequestMethod.DELETE)
	public Map<String, Object>  deleteMinCalendaryCattle(@PathVariable("id") Long id){
		return calendaryCattleService.deleteMin(id);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/fish",method=RequestMethod.POST)
	public Map<String, Object>  addMinCalendaryFish(@RequestBody FishCalendaryMin min){
		return calendaryFishService.addMin(min);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/fish/{id}",method=RequestMethod.DELETE)
	public Map<String, Object>  deleteMinCalendaryFish(@PathVariable("id") Long id){
		return calendaryFishService.deleteMin(id);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/poultry",method=RequestMethod.POST)
	public Map<String, Object>  addMinCalendaryPoultry(@RequestBody PoultryCalendaryMin min){
		return calendaryPoultryService.addMin(min);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/poultry/{id}",method=RequestMethod.DELETE)
	public Map<String, Object>  deleteMinCalendaryPoultry(@PathVariable("id") Long id){
		return calendaryPoultryService.deleteMin(id);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/speculation",method=RequestMethod.POST)
	public Map<String, Object>  addMinCalendarySpeculation(@RequestBody SpeculationCalendaryMin min){
		return calendarySpeculationService.addMin(min);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/speculation/{id}",method=RequestMethod.DELETE)
	public Map<String, Object>  deleteMinCalendarySpeculation(@PathVariable("id") Long id){
		return calendarySpeculationService.deleteMin(id);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/tree",method=RequestMethod.POST)
	public Map<String, Object>  addMinCalendaryTree(@RequestBody TreeCalendaryMin min){
		return calendaryTreeService.addMin(min);
	}
	
	@RequestMapping(value="/api/v1/min/calendar/tree/{id}",method=RequestMethod.DELETE)
	public Map<String, Object>  addMinCalendaryTree(@PathVariable("id") Long id){
		return calendaryTreeService.deleteMin(id);
	}
	
	@RequestMapping(value="/api/v1/delete/calendar/cattle/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteCattle(@PathVariable("id") Long id){
		return calendaryCattleService.delete(id);
	}
	
	@RequestMapping(value="/api/v1/delete/calendar/poultry/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deletePoultry(@PathVariable("id") Long id){
		return calendaryPoultryService.delete(id);
	}
	
	@RequestMapping(value="/api/v1/delete/calendar/speculation/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteSpeculation(@PathVariable("id") Long id){
		return calendarySpeculationService.delete(id);
	}
	
	@RequestMapping(value="/api/v1/delete/calendar/tree/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteTree(@PathVariable("id") Long id){
		return calendaryTreeService.delete(id);
	}
	
	@RequestMapping(value="/api/v1/delete/calendar/fish/{id}", method=RequestMethod.DELETE)
	public Map<String, Object> deleteFish(@PathVariable("id") Long id){
		return calendaryFishService.delete(id);
	}
	
	@RequestMapping(value = "/api/v1/make/speculation/{id}",method = RequestMethod.GET)
	public Map<String, Object> updateCalendarySpeculation(@PathVariable("id") Long id){
		return calendarySpeculationService.makeTrue(id);
	}
	
	@RequestMapping(value = "/api/v1/giveUp/speculation",method = RequestMethod.POST)
	public Map<String, Object> giveUpSpeculation(@RequestBody CalendarySpeculation cal){
		return calendarySpeculationService.giveUpTrue(cal);
	}
	
	@RequestMapping(value = "/api/v1/make/tree/{id}",method = RequestMethod.GET)
	public Map<String, Object> updateCalendaryTree(@PathVariable("id") Long id){
		return calendaryTreeService.makeTrue(id);
	}
	
	@RequestMapping(value = "/api/v1/make/cattle/{id}",method = RequestMethod.GET)
	public Map<String, Object> updateCalendaryCattle(@PathVariable("id") Long id){
		return calendaryCattleService.makeTrue(id);
	}
	
	@RequestMapping(value = "/api/v1/make/fish/{id}",method = RequestMethod.GET)
	public Map<String, Object> updateCalendaryFish(@PathVariable("id") Long id){
		return calendaryFishService.makeTrue(id);
	}
	
	@RequestMapping(value = "/api/v1/make/poultry/{id}",method = RequestMethod.GET)
	public Map<String, Object> updateCalendaryPoultry(@PathVariable("id") Long id){
		return calendaryPoultryService.makeTrue(id);
	}
	
	@RequestMapping(value = "/api/v1/calendary/category/poultry/min/{id}",method = RequestMethod.GET)
	public Map<String, Object> getMinCalendarPoultry(@PathVariable("id") Long id){
		return calendaryPoultryService.findByCategory(id);
	}
	
	@RequestMapping(value = "/api/v1/calendary/category/cattle/min/{id}",method = RequestMethod.GET)
	public Map<String, Object> getMinCalendarCattle(@PathVariable("id") Long id){
		return calendaryCattleService.findByCategory(id);
	}
	
	@RequestMapping(value = "/api/v1/calendary/category/fish/min/{id}",method = RequestMethod.GET)
	public Map<String, Object> getMinCalendarFish(@PathVariable("id") Long id){
		return calendaryFishService.findByCategory(id);
	}
	
	@RequestMapping(value = "/api/v1/calendary/category/tree/min/{id}",method = RequestMethod.GET)
	public Map<String, Object> getMinCalendarTree(@PathVariable("id") Long id){
		return calendaryTreeService.findByCategory(id);
	}
	
	@RequestMapping(value = "/api/v1/calendary/category/speculation/min/{id}",method = RequestMethod.GET)
	public Map<String, Object> getMinCalendarSpeculation(@PathVariable("id") Long id){
		return calendarySpeculationService.findBySeed(id);
	}
}
