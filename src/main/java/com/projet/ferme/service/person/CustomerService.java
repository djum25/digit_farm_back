package com.projet.ferme.service.person;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.ferme.entity.person.Customer;
import com.projet.ferme.entity.stocks.Sale;
import com.projet.ferme.repository.person.CustomerRepository;
import com.projet.ferme.repository.stocks.SaleRepository;
import com.projet.ferme.service.utile.MapResponse;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private SaleRepository saleRepository;

    public Map<String,Object> addCustomer(Customer customer) {
        
        if (customerRepository.findByTelephone(customer.getTelephone()).isEmpty()) {
            Customer savedCustomer = customerRepository.save(customer);
            if (savedCustomer == null) {
                return new MapResponse().withSuccess(false).
                withMessage("L'enregistrement à échoué réessayez svp !").response();
            }else{
                return new MapResponse().withSuccess(true).withObject(savedCustomer).
                withMessage("L'enregistrement à réussit !").response();
            }
        }else{
            return new MapResponse().withSuccess(false).
            withMessage("Le client exist déja !").response();
        }
    }

    public Map<String,Object> findAll() {
        List<Customer> customers = customerRepository.findAll();
        return new MapResponse().withSuccess(true).withObject(customers)
        .withMessage(customers.size()+" enrégistrements trouvés").response();
    }

    public Map<String, Object> delete(Long id){
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return new MapResponse().withSuccess(true).
            withMessage("Supprimer avec succé").response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Le client n'est pas dans la base de données").response();
        }
    }

    public Map<String, Object> getNoReimburseSale(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isEmpty()){
            return new MapResponse().withMessage("Le client n'est plus dans la base").
            withSuccess(false).response();
        }else{
            List<Sale> sales = saleRepository.findByCustomer_id(id);
            return new MapResponse().withSuccess(true).withObject(customer.get()).
            withArrayObject(sales).withMessage(sales.size()+" Enregistrement trouvés").response();
        }
    }
}
