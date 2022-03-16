package com.projet.ferme.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.Cashier;
import com.projet.ferme.entity.OutgoingStock;
import com.projet.ferme.entity.Sale;
import com.projet.ferme.entity.Shop;
import com.projet.ferme.entity.User;
import com.projet.ferme.repository.CashierRepository;
import com.projet.ferme.repository.OutgoingStockRepository;
import com.projet.ferme.repository.ShopRepository;
import com.projet.ferme.repository.UserRepository;

@Service
public class OutgoingService {

	@Autowired
	private OutgoingStockRepository repository;
	@Autowired
	private SaleService saleService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ShopRepository shopRepository;
	@Autowired
	private CashierRepository cashierRepository;

	public Map<String, Object> add(OutgoingStock stock) {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		if (stock.getType().equals("in")) {
			OutgoingStock newStock = repository.save(stock);
			if (newStock == null) {
				returnMap.put("success", false);
				returnMap.put("message", "L'enregistrement a échoué");
			} else {
				returnMap.put("success", true);
				returnMap.put("message", "Enregistré avec succé");
				returnMap.put("stock", newStock);
			}
		} else {
			List<OutgoingStock> stocks = repository.findByProduit(stock.getProduit());

			Integer quantityReel = stocks.stream().filter(item -> item.getType().equals("in"))
					.mapToInt(item -> item.getQuantity()).sum()
					- stocks.stream().filter(item -> item.getType().equals("out")).mapToInt(item -> item.getQuantity())
							.sum();

			if (quantityReel < stock.getQuantity()) {
				returnMap.put("success", false);
				returnMap.put("message", "L'enregistrement a échoué car la quantité demandé n'est pas disponible");
			} else {
				OutgoingStock newStock = repository.save(stock);
				if (newStock == null) {
					returnMap.put("success", false);
					returnMap.put("message", "L'enregistrement a échoué");
				} else {
					returnMap.put("success", true);
					returnMap.put("message", "Enregistré avec succé");
					returnMap.put("stock", newStock);
				}
			}
		}

		return returnMap;
	}

	public Map<String, Object> put(OutgoingStock stock) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		OutgoingStock oldStock = repository.getById(stock.getId());

		if (oldStock == null) {
			returnMap.put("success", false);
			returnMap.put("message", "L'enregistrement n'est plus dans la base");
		} else if (stock.getQuantity() != oldStock.getQuantity()) {
			returnMap.put("success", false);
			returnMap.put("message", "La modification n'est pas permise sur la quantité");
		} else {
			OutgoingStock updateStock = repository.save(stock);
			if (updateStock == null) {
				returnMap.put("success", false);
				returnMap.put("message", "La modification a échoué");
			} else {
				returnMap.put("success", true);
				returnMap.put("message", "Modifié avec succé");
				returnMap.put("stock", stock);
			}
		}
		return returnMap;
	}

	public Map<String, Object> getProduitInStock() {

		List<Map<String, Object>> maps = new ArrayList<>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<OutgoingStock> stocks = repository.findAll();

		stocks.stream().collect(Collectors.groupingBy(OutgoingStock::getProduit)).forEach((value, values) -> {
			Map<String, Object> xx = new HashMap<String, Object>();
			xx.put("product", value);
			xx.put("actualy", values.stream().filter(s -> s.getType().equals("in")).mapToInt(v -> v.getQuantity()).sum()
					- values.stream().filter(s -> s.getType().equals("out")).mapToInt(v -> v.getQuantity()).sum());
			maps.add(xx);
		});

		returnMap.put("success", true);
		returnMap.put("stocks", maps);

		return returnMap;
	}

	public Map<String, Object> getByProduit(String produit) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<OutgoingStock> stocks = repository.findByProduit(produit);

		returnMap.put("success", true);
		returnMap.put("outgoingStocks", stocks);

		return returnMap;
	}

	public Map<String, Object> getByType(String type) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		List<OutgoingStock> stocks = repository.findByType(type);

		returnMap.put("success", true);
		returnMap.put("stocks", stocks);

		return returnMap;
	}

	public List<OutgoingStock> findBySubjectId(String subjectId) {
		List<OutgoingStock> stock = repository.findBySubjectId(subjectId);

		return stock;
	}

	public Map<String, Object> delete(Long id) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		repository.deleteById(id);
		returnMap.put("success", true);
		returnMap.put("message", "Supprimé avec succé");

		return returnMap;
	}

	public Map<String, Object> deleteDirectly(Long id) {

		Map<String, Object> returnMap = new HashMap<String, Object>();
		OutgoingStock stock = repository.getById(id);

		if (stock.getType().equals("in")) {
			returnMap.put("success", false);
			returnMap.put("message", "restriction sur les stocks entrants");
		} else {
			repository.deleteById(id);
			returnMap.put("success", true);
			returnMap.put("message", "Supprimé avec succé");
		}

		return returnMap;
	}

	public Map<String, Object> addForSell(OutgoingStock stock, String username, Long idShop) {
		Map<String, Object> returnMap = new HashMap<String, Object>();

		List<OutgoingStock> stocks = repository.findByProduit(stock.getProduit());

		Integer quantityIn = stocks.stream().filter(item -> item.getType().equals("in"))
				.mapToInt(item -> item.getQuantity()).sum();

		Integer quantityOut = stocks.stream().filter(item -> item.getType().equals("out"))
				.mapToInt(item -> item.getQuantity()).sum();

		Integer quantityReel = quantityIn - quantityOut;

		Cashier cashier = getCashier(username, idShop);

		if (cashier == null) {
			returnMap.put("success", false);
			returnMap.put("message", "Vous n'etes pas un caissier");
		} else if (!cashier.isActive()) {
			returnMap.put("success", false);
			returnMap.put("message", "Votre accée a la caisse est désactivé veullier contacter l'administrateur");
		} else if (!cashier.isStatus()) {
			returnMap.put("success", false);
			returnMap.put("message", "Veuliiez ouvrir une caisse svp");
		} else {

			if (quantityReel < stock.getQuantity()) {
				returnMap.put("success", false);
				returnMap.put("message", "L'enregistrement a échoué car la quantité demandé n'est pas disponible");
			} else {
				OutgoingStock newStock = repository.save(stock);
				if (newStock == null) {
					returnMap.put("success", false);
					returnMap.put("message", "L'enregistrement a échoué");
				} else {
					saveSale(null, newStock, cashier);
					returnMap.put("success", true);
					returnMap.put("message", "Enregistré avec succé");
					returnMap.put("stock", newStock);
				}
			}
		}

		return returnMap;
	}

	private void saveSale(Long id, OutgoingStock stock, Cashier cashier) {

		String subjectId = "stock_" + stock.getId().toString();
		Sale sale = new Sale();
		sale.setId(id);
		sale.setProduit(stock.getProduit());
		sale.setPrice(stock.getValeur());
		sale.setQuantity(stock.getQuantity());
		sale.setDate(stock.getCreatedOn());
		sale.setCreatedOn(stock.getCreatedOn());
		sale.setUpdatedOn(stock.getUpdatedOn());
		sale.setSubjectId(subjectId);
		sale.setCashier(cashier);
		saleService.add(sale);
	}

	private Cashier getCashier(String username, Long idShop) {
		Cashier cashier = new Cashier();
		Optional<User> user = userRepository.findByUsername(username);
		Optional<Shop> shop = shopRepository.findById(idShop);

		if (user.isPresent() && shop.isPresent()) {
			Optional<Cashier> cashierOptional = cashierRepository.findByUser_idAndShop_id(user.get().getId(),
					shop.get().getId());
			cashier = cashierOptional.get();
		}
		return cashier;
	}

}
