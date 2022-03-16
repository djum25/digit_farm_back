package com.projet.ferme.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projet.ferme.entity.IncomingStock;
import com.projet.ferme.entity.OutgoingStock;
import com.projet.ferme.service.IncomingService;
import com.projet.ferme.service.OutgoingService;

@RestController
public class StockController {

	@Autowired
	private IncomingService incomingService;
	@Autowired
	private OutgoingService outgoingService;
	
	@RequestMapping(value = "/api/v1/incoming", method = RequestMethod.POST)
	public Map<String, Object> postIncomingStock(@RequestBody IncomingStock stock){
		return incomingService.add(stock);
	}
	
	@RequestMapping(value = "/api/v1/incoming", method = RequestMethod.PUT)
	public Map<String, Object> putIncomingStock(@RequestBody IncomingStock stock){
		return incomingService.put(stock);
	}
	
	/*@RequestMapping(value = "/api/v1/incoming/name/{name}", method = RequestMethod.GET)
	public Map<String, Object> getByNameIncomingStock(@PathVariable("name") String name){
		return incomingService.getByName(name);
	}*/
	
	@RequestMapping(value = "/api/v1/incoming/type/{type}", method = RequestMethod.GET)
	public Map<String, Object> getByTypeIncomingStock(@PathVariable("type") String type){
		return incomingService.getByType(type);
	}
	
	@RequestMapping(value = "/api/v1/incoming/{product}", method = RequestMethod.GET)
	public Map<String, Object> getIncomingStock(@PathVariable("product") String product){
		return incomingService.findByProduct(product);
	}
	
	@RequestMapping(value = "/api/v1/incoming/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteIncomingStock(@PathVariable("id") Long id){
		return incomingService.delete(id);
	}
	
	@RequestMapping(value = "/api/v1/outgoing", method = RequestMethod.POST)
	public Map<String, Object> postOutgoing(@RequestBody OutgoingStock stock){
		return outgoingService.add(stock);
	}
	
	@RequestMapping(value = "/api/v1/outgoing", method = RequestMethod.PUT)
	public Map<String, Object> putOutgoing(@RequestBody OutgoingStock stock){
		return outgoingService.put(stock);
	}
	
	@RequestMapping(value = "/api/v1/outgoing/produit", method = RequestMethod.GET)
	public Map<String, Object> getByProduitOutgoingStock(){
		return outgoingService.getProduitInStock();
	}
	
	@RequestMapping(value = "/api/v1/outgoing/type/{type}", method = RequestMethod.GET)
	public Map<String, Object> getByTypeOutgoingStock(@PathVariable("type") String type){
		return outgoingService.getByType(type);
	}
	
	@RequestMapping(value = "/api/v1/outgoing/{id}", method = RequestMethod.DELETE)
	public Map<String, Object> deleteOutgoingStock(@PathVariable("id") Long id){
		return outgoingService.deleteDirectly(id);
	}
	
	@RequestMapping(value = "/api/v1/outgoing/{produit}", method = RequestMethod.GET)
	public Map<String, Object> getByProduitStock(@PathVariable("produit") String produit){
		return outgoingService.getByProduit(produit);
	}
	
	@RequestMapping(value = "/api/v1/outgoing/sale/{username}/{id}", method = RequestMethod.POST)
	public Map<String, Object> addForSale(@RequestBody OutgoingStock stock,@PathVariable("username") String username,@PathVariable("id") Long idShop){
		return outgoingService.addForSell(stock,username,idShop);
	}
}
