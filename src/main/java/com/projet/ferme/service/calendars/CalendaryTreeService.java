package com.projet.ferme.service.calendars;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.calendars.CalendaryTree;
import com.projet.ferme.entity.calendars.TreeCalendaryMin;
import com.projet.ferme.entity.category.TreeCategory;
import com.projet.ferme.entity.subject.Tree;
import com.projet.ferme.repository.CalendaryTreeRepository;
import com.projet.ferme.repository.TreeCalendaryMinRepository;
import com.projet.ferme.repository.TreeCategoryRepository;
import com.projet.ferme.repository.TreeRepository;

@Service
public class CalendaryTreeService {

	@Autowired
	private CalendaryTreeRepository repository;
	@Autowired
	private TreeCalendaryMinRepository minRepository;
	@Autowired
	private TreeCategoryRepository categoryRepository;
	@Autowired
	private TreeRepository treeRepository;
	
	public Map<String, Object> add(CalendaryTree cal){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		CalendaryTree calendar = repository.save(cal);
		
		if(calendar == null) {
			returnValues.put("success", false);
			returnValues.put("calendar", calendar);
		}else {
			returnValues.put("success", true);
			returnValues.put("calendar", calendar);
		}
		return returnValues;
	}
	
	public Map<String, Object> findByTreeId(Long id) {
		Map< String, Object> map = new HashMap<String, Object>();
		Tree tree = treeRepository.findById(id).get();
		List<CalendaryTree> calendaryTrees = repository.findByTree_id(id);
		map.put("success", true);
		map.put("calendars", calendaryTrees);
		map.put("tree", tree);
		
		return map;
	}
	
	public Map<String, Object> makeTrue(Long id){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		
		CalendaryTree calendaryTree = repository.getById(id);
		if(calendaryTree == null) {
			returnValues.put("success", false);
			returnValues.put("message", "Enregistrement introuvable");
		}else {
			java.util.Date date=new java.util.Date();
			Date sqlStartDate = new Date(date.getTime());
			calendaryTree.setUpdatedOn(sqlStartDate);
			calendaryTree.setMake(true);
			calendaryTree = repository.save(calendaryTree);
			returnValues.put("success", false);
			returnValues.put("message", "Enregistrement réussi");
		}
		return returnValues;
	}
	
	public Map<String, Object> addMin(TreeCalendaryMin min){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		
		TreeCalendaryMin minCalendar = minRepository.save(min);
		
		if(minCalendar == null) {
			returnValues.put("success", false);
			returnValues.put("minCalendar", minCalendar);
		}else {
			returnValues.put("success", true);
			returnValues.put("minCalendar", minCalendar);
		}
		return returnValues;
	}
	
	public Map<String, Object> delete(Long id){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		repository.deleteById(id);
		returnValues.put("success", true);
		return returnValues;
	}
	
	public Map<String, Object> deleteMin(Long id){
		
		Map<String, Object> returnValues = new HashMap<String, Object>();
		minRepository.deleteById(id);
		returnValues.put("success", true);
		return returnValues;
	}
	
	public Map<String, Object> findByCategory(Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<TreeCalendaryMin> calendaryMins = minRepository.findByCategoryId(id);
		TreeCategory category = categoryRepository.findById(id).get();
		
		map.put("success", true);
		map.put("calendaryMins", calendaryMins);
		map.put("category", category);
		
		return map;
	}
}
