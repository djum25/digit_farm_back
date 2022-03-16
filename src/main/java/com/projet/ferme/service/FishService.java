package com.projet.ferme.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.Bowl;
import com.projet.ferme.entity.CalendaryFish;
import com.projet.ferme.entity.Fish;
import com.projet.ferme.entity.FishCalendaryMin;
import com.projet.ferme.entity.FishCategory;
import com.projet.ferme.repository.BowlRepository;
import com.projet.ferme.repository.CalendaryFishRepository;
import com.projet.ferme.repository.FishCalendaryMinRepository;
import com.projet.ferme.repository.FishRepository;

@Service
public class FishService {

	@Autowired
	private FishRepository fishRepository;
	@Autowired
	private FishCalendaryMinRepository minRepository;
	@Autowired
	private CalendaryFishRepository calendaryFishRepository;
	@Autowired
	private MatriculeService matricule;
	@Autowired
	private BowlRepository bowlRepository;
	@Autowired
	private CategoryFishService categoryFishService;
	
	public Map<String, Object> add(Fish fish) {

		Map<String, Object> returnValues = new HashMap<String, Object>();
		
		fish.setName(matricule.getName(fish.getCategory().getName()));
		Fish newFish = fishRepository.save(fish);

		if (newFish == null) {
			returnValues.put("success", false);
			returnValues.put("fish", newFish);
		} else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			List<FishCalendaryMin> mins = minRepository.findByCategoryId(newFish.getCategory().getId());
			for(FishCalendaryMin min: mins) {
				CalendaryFish cal = new CalendaryFish();
				Calendar c = Calendar.getInstance();
				c.setTime(newFish.getDate());
				c.add(Calendar.DATE,min.getOld());
				cal.setFish(newFish);
				cal.setCalendaryName(min.getName());
				Date x = new Date(c.getTimeInMillis());
				cal.setDate(x);
				cal.setCreatedOn(sqlStartDate);
				cal.setIntervention(min.getIntervention());
				cal.setMake(false);
				cal.setUpdatedOn(null);
				cal.setId(null);
				
				calendaryFishRepository.save(cal);
			}
			returnValues.put("success", true);
			returnValues.put("fish", newFish);
		}

		return returnValues;
	}

	public Map<String, Object> put(Fish fish) {

		Map<String, Object> returnValues = new HashMap<String, Object>();
		Fish newFish = fishRepository.save(fish);

		if (newFish != null) {
			returnValues.put("success", true);
			returnValues.put("fish", newFish);
		} else {

			returnValues.put("success", false);
			returnValues.put("fish", newFish);
		}

		return returnValues;
	}

	public Map<String, Object> get() {

		Map<String, Object> returnValues = new HashMap<String, Object>();
		List<Fish> fishs = fishRepository.findAll();

		returnValues.put("success", true);
		returnValues.put("fishs", fishs);

		return returnValues;
	}

	public Map<String, Object> findByPresent(boolean b) {

		Map<String, Object> returnValues = new HashMap<String, Object>();
		List<Fish> fishs = fishRepository.findByPresent(b);

		returnValues.put("success", true);
		returnValues.put("fishs", fishs);

		return returnValues;
	}
	
	public Map<String, Object> findByName(String name) {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		Optional<Fish> fish = fishRepository.findByName(name);
		
		if(fish == null) {
			returnValues.put("success", false);
			returnValues.put("fish", fish);
		}else {
			returnValues.put("success", true);
			returnValues.put("fish", fish);
		}
		return returnValues;
	}

	public Map<String, Object> delete(Long id) {

		Map<String, Object> returnValues = new HashMap<String, Object>();
		fishRepository.deleteById(id);

		returnValues.put("success", true);

		return returnValues;
	}
	
	public Map<String, Object> count() {
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		
		int isPresent = fishRepository.countByPresent(true);
		int isMissing = fishRepository.countByPresent(false);
		
		returnValues.put("success", true);
		returnValues.put("present", isPresent);
		returnValues.put("missing",isMissing);
		
		return returnValues;
	}
	
	public Map<String, Object> fishByBowl(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Fish> fishs = fishRepository.findByBowl_id(id);
		Optional<Bowl> bowl = bowlRepository.findById(id);
		
		map.put("success", true);
		map.put("bowl", bowl.get());
		map.put("fishs", fishs);
		
		return map;
	}
	
	public Map<String, Object> findByCategory(Long id){
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Fish> fishs = fishRepository.findByCategory_id(id);
		FishCategory fishCategory = categoryFishService.findById(id);
		map.put("success", true);
		map.put("category", fishCategory);
		map.put("fishs", fishs);
		
		
		return map;
	}
	
}
