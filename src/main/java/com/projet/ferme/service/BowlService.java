package com.projet.ferme.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.Bowl;
import com.projet.ferme.repository.BowlRepository;

@Service
public class BowlService {

	@Autowired
	private BowlRepository repository;
	
	public Map<String, Object> add(Bowl B){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Bowl bowl = repository.save(B);
		if(bowl == null) {
			returnMap.put("success", false);
			returnMap.put("bowl", bowl);
		}else {
			returnMap.put("success", true);
			returnMap.put("bowl", bowl);
		}
		return returnMap;
	}
	
	public Map<String, Object> put(Bowl B){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Bowl bowl = repository.save(B);
		if(bowl == null) {
			returnMap.put("success", false);
			returnMap.put("bowl", bowl);
		}else {
			returnMap.put("success", true);
			returnMap.put("bowl", bowl);
		}
		return returnMap;
	}
	
	public Map<String, Object> findAll(){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Bowl> bowls = repository.findAll();
		if(bowls == null) {
			returnMap.put("success", false);
			returnMap.put("bowls", bowls);
		}else {
			returnMap.put("success", true);
			returnMap.put("bowls", bowls);
		}
		return returnMap;
	}
	
	public Map<String, Object> delete(Long id){
		Map<String, Object> returnMap = new HashMap<String, Object>();
		repository.deleteById(id);
		returnMap.put("success", true);
		return returnMap;
	}
}
