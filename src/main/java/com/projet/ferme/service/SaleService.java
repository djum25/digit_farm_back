package com.projet.ferme.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.stocks.Sale;
import com.projet.ferme.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public Map<String, Object> add(Sale s){
		Map<String, Object> returnMap = new HashMap<String,Object>();
		Sale sale = repository.save(s);
		if(sale == null) {
			returnMap.put("success", false);
			returnMap.put("message", "Echec de l'enregistrement");
		}else {
			returnMap.put("succes", true);
			returnMap.put("message", "Enregistré avec succé");
		}
		return returnMap;
	}
	
	public Sale findBySubject(String subjectId) {
		Sale sale = repository.findBySubjectId(subjectId);
		
		return sale;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
