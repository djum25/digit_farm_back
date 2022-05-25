package com.projet.ferme.service.comptability;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.person.Cashier;
import com.projet.ferme.entity.stocks.Sale;
import com.projet.ferme.repository.stocks.SaleRepository;

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

	public int findSaleToCount(Cashier cashier){
		List<Sale> sales = repository.findByCashier_id(cashier.getId());
		sales = sales.stream().filter(s-> !s.isCounted()).
		map(s-> {s.setCounted(true); return s;}).collect(Collectors.toList());
		return repository.saveAll(sales).size();
	}
}
