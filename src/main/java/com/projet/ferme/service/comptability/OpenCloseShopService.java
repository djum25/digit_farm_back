package com.projet.ferme.service.comptability;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.comptability.Compte;
import com.projet.ferme.entity.comptability.Operation;
import com.projet.ferme.entity.comptability.Reimburse;
import com.projet.ferme.entity.person.Cashier;
import com.projet.ferme.entity.person.CashierNew;
import com.projet.ferme.entity.person.User;
import com.projet.ferme.entity.stocks.Sale;
import com.projet.ferme.entity.stocks.Shop;
import com.projet.ferme.entity.utils.NewDate;
import com.projet.ferme.repository.comptability.CompteRepository;
import com.projet.ferme.repository.comptability.OperationRepository;
import com.projet.ferme.repository.comptability.ReimburseRepository;
import com.projet.ferme.repository.person.CashierNewRepository;
import com.projet.ferme.repository.person.CashierRepository;
import com.projet.ferme.repository.stocks.SaleRepository;
import com.projet.ferme.service.utile.MapResponse;
import com.projet.ferme.service.utile.MapToObject;
import com.projet.ferme.service.utile.UserAuthenticate;

@Service
public class OpenCloseShopService {
    
    @Autowired 
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CashierRepository cashierRepository;
    @Autowired
    private CashierNewRepository cashierNewRepository;
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private UserAuthenticate userAuthenticate;
    @Autowired
    private ReimburseRepository reimburseRepository;

    public Map<String, Object> mainMethod(Map<String,Object> enterMap){
        MapToObject mapToObject = new MapToObject(enterMap);
        Optional<Cashier> cashier = getCashier(mapToObject.getLong("shopId"));
        if (cashier.isPresent()) {
            if(cashier.get().getAccess() == mapToObject.getInteger("access")){
                Map<String, Object> map = new HashMap<String, Object>();
                CashierNew cashierNew = getStatus(mapToObject.getLong("shopId"));
                if (cashierNew.isOpen()) {
                    map.put("status", cashierNew.isOpen());
                    map.put("cashier", cashierNew.getCashier());
                    int cash = getCash(cashier.get());
                    if (cashierNew.isCounted()) {
                        map.put("cash", cash);
                    } else {
                        cash = cash + cashierNew.getCash();
                        map.put("cash", cash);
                    }
                    return new MapResponse().withObject(map).withSuccess(true)
                    .withMessage("Voulez vous fermer la caisse avec "+cash+"Fcfa ?")
                    .response();
                } else {    
                    map.put("status", cashierNew.isOpen());
                    map.put("cash", cashierNew.getCash());
                    map.put("cashier", cashierNew.getCashier());
                    return new MapResponse().withObject(map).withSuccess(true)
                    .withMessage("Voulez vous ouvrir la caisse avec "+cashierNew.getCash()+"Fcfa ?")
                    .response();
                }
            }else{
                return new MapResponse().withSuccess(false)
                .withMessage("Votre code d'accés n'est pas correct")
                .response();
            }
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Vous n'etes pas cashier dans cette boutique")
            .response();
        }
    }

    public Map<String,Object> openShop(Map<String,Object> enterMap){
        MapToObject mapToObject = new MapToObject(enterMap);
        if (isOpen(mapToObject.getLong("shopId"))) {
            return new MapResponse().withSuccess(false).withMessage("La boutique est déja ouverte")
            .response();
        } else {
        Optional<Cashier> cashier = getCashier(mapToObject.getLong("shopId"));
        CashierNew cashierNew = addNews(cashier.get(), true, mapToObject.getInteger("cash"));
        if (cashierNew == null) {
            return new MapResponse().withSuccess(false)
            .withMessage("Une erreur c'est produite veuillez rééssayer")
            .response();
        } else {
            return new MapResponse().withSuccess(true)
            .withObject(cashierNew).withMessage("Ouvert avec succé").response();
        }}
    }

    public Map<String,Object> closeShop(Map<String,Object> enterMap){

        MapToObject mapToObject = new MapToObject(enterMap);
        
        Optional<Cashier> cashier = getCashier(mapToObject.getLong("shopId"));
        int cash = getCash(cashier.get());
        CashierNew cashierNew = getStatus(cashier.get().getShop().getId());
        if (!cashierNew.isCounted()) {
            cash = cash + cashierNew.getCash();
        }

        CashierNew savedCashierNew = addNews(cashier.get(), false, cash);
        if (savedCashierNew == null) {
            return new MapResponse().withSuccess(false)
            .withMessage("Une erreur c'est produite veuillez rééssayer")
            .response();
        } else {
            saveCash(cash, cashier.get());
            updateNew(cashier.get());
            return new MapResponse().withSuccess(true)
            .withObject(cashierNew).withMessage("Fermé avec succé").response();
        }
    }

    public Map<String,Object> amountToSave(Long shopId){
        Optional<Cashier> cashier = getCashier(shopId);
        int reimburse = getamountReimburse(cashier.get());
        int sale = getCash(cashier.get());
        String msg = "Voulez vous verser "+sale+"Fcfa de vente et "+reimburse+"Fcfa de remboursement";
        return new MapResponse().withSuccess(true).withMessage(msg).response();
    }

    public Map<String,Object> saveInComptability(Long shopId,int cash){
        Optional<Cashier> cashier = getCashier(shopId);
        int reimburse = getamountReimburse(cashier.get());
        int sale = getCash(cashier.get());
        return new MapResponse().response();
    }

    private Optional<Cashier> getCashier(Long shopId){
        User user = userAuthenticate.getUserAuthenticate();
        Optional<Cashier> cashier = cashierRepository.findByUser_idAndShop_id(user.getId(), shopId);
        return cashier;
    }

    private int getCash(Cashier cashier){
        List<Sale> sales = saleRepository.findByCashier_id(cashier.getId());
        int cash = sales.stream().filter(sale -> !sale.isCounted())
        .mapToInt(sale -> sale.getAdvance()).sum();
        return cash;
    }

    private void makeCounted(Cashier cashier){
        List<Sale> sales = saleRepository.findByCashier_id(cashier.getId());
        sales = sales.stream().filter(sale -> !sale.isCounted()).collect(Collectors.toList());
        List<Sale> transformSales = new ArrayList<Sale>();
        sales.stream().forEach(sale-> {sale.setCounted(true);transformSales.add(sale);});
        sales = saleRepository.saveAll(transformSales);
        System.out.println(sales);
    }

    private int getamountReimburse(Cashier cashier){
        List<Reimburse> reimburses = reimburseRepository.findByCashier_id(cashier.getId());
        int amount = reimburses.stream().filter(reimburse-> !reimburse.isCounted())
        .mapToInt(reimburse-> reimburse.getSale().getAccount()).sum();
        return amount;
    }

    private CashierNew getStatus(Long shopId){
        List<Cashier> cashiers = cashierRepository.findByShop_id(shopId);
        List<CashierNew> cashierNews = cashierNewRepository.findAll();
        cashierNews = cashierNews.stream().filter(cashierNew->cashiers.contains(cashierNew.getCashier())).collect(Collectors.toList());
        if (cashierNews.size() == 0) {
            CashierNew cashierNew = new CashierNew();
            cashierNew.setCounted(true);
            cashierNew.setOpen(false);
            cashierNew.setCash(0);
            return cashierNew;
        } else {
            CashierNew cashierNew = cashierNews.stream().max(Comparator.comparing(CashierNew::getTime)).get();
            return cashierNew;
        }
    }
    
    private boolean saveCash(int amount,Cashier cashier){
        Optional<Compte> compte = compteRepository.findByNumber("5314");
        if(compte.isPresent()){
            Operation operation = new Operation();
            operation.setAmount(amount);
            operation.setComment("Argent dans la caisse par "+cashier.getUser().getFirstname()+" "+
             cashier.getUser().getLastname()+
            " pour la boutique "+cashier.getShop().getName());
            operation.setCompte(compte.get());
            operation.setCreatedOn(new NewDate().getDate());
            operation.setUpdatedOn(new NewDate().getDate());
            operation.setDate(LocalDateTime.now());
            operation.setLabel("Vente de produits non versé");
            Operation savedOperation = operationRepository.save(operation);
            if (savedOperation != null){
                makeCounted(cashier);
                return true;
            }else
                return false;
        }else{
            return false;
        }
    }

    private CashierNew addNews(Cashier cashier, boolean open,int cash) {
		
		CashierNew cashierNew = new CashierNew();

		cashierNew.setTime(LocalDateTime.now());
		cashierNew.setOpen(open);
		cashierNew.setCash(cash);
		cashierNew.setCashier(cashier);
        cashierNew.setCounted(false);
		
		CashierNew savedCashierNew = cashierNewRepository.save(cashierNew);

		return savedCashierNew;
	}

    private boolean updateNew(Cashier cashier){
            List<CashierNew> news = cashierNewRepository.findByCashier_id(cashier.getId());
            CashierNew cashierNew = news.stream().max(Comparator.comparing(CashierNew::getTime)).get();
            cashierNew.setCounted(true);
            CashierNew saveNew = cashierNewRepository.save(cashierNew);
            if (saveNew == null) {
                return false;
            } else {
                return true;
            }
    }

    private boolean isOpen(Long shopId) {
		List<Cashier> cashiers = cashierRepository.findByShop_id(shopId);
		return cashiers.stream().noneMatch(item-> item.isStatus());
	}

    private boolean amountForKeep(int keepAmount,Cashier cashier){
        if (keepAmount > 0) {
            //Capital social, appelé, non versé
            Optional<Compte> compte = compteRepository.findByNumber("1012");
            if(compte.isPresent()){
                Operation operation = new Operation();
                operation.setAmount(keepAmount);
                operation.setComment("Garder pour fond de caisse "+cashier.getUser().getFirstname()+" "
                +cashier.getUser().getLastname()+
                " pour la boutique "+cashier.getShop().getName());
                operation.setCompte(compte.get());
                operation.setCreatedOn(new NewDate().getDate());
                operation.setUpdatedOn(new NewDate().getDate());
                operation.setDate(LocalDateTime.now());
                operation.setLabel("Vente des produits");
                Operation savedOperation = operationRepository.save(operation);
                if (savedOperation != null)
                    return true;
                else
                    return false;
            }else{
                return false;
            }
        }else{
            return true;
        }
    }
}
