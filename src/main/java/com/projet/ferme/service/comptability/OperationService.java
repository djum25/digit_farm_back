package com.projet.ferme.service.comptability;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.projet.ferme.entity.comptability.CategoryCompte;
import com.projet.ferme.entity.comptability.Compte;
import com.projet.ferme.entity.comptability.Operation;
import com.projet.ferme.repository.category.CategoryCompteRepository;
import com.projet.ferme.repository.comptability.CompteRepository;
import com.projet.ferme.repository.comptability.OperationRepository;
import com.projet.ferme.service.utile.MapResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CategoryCompteRepository categoryCompteRepository;
    @Autowired
    private CompteRepository CompteRepository;

    public Map<String, Object> addOperation(Operation operation){

        Operation savedOperation = operationRepository.save(operation);
        if (savedOperation != null) {
            return new MapResponse().withSuccess(true).withObject(savedOperation)
            .withMessage("Enregistrement réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("L'enregistrement a échoué Veuillez réessayer ").response();
        }
    }

    public Map<String, Object> updateOperation(Operation operation) {
        
        if (operationRepository.findById(operation.getId()).isPresent()) {
            Operation savedOperation = operationRepository.save(operation);
            if (savedOperation != null) {
                return new MapResponse().withSuccess(true).withObject(savedOperation)
                .withMessage("Enregistrement réussit").response();
            } else {
                return new MapResponse().withSuccess(false)
                .withMessage("L'enregistrement a échoué Veuillez réessayer ").response();
            }
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Cette enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> deleteOperation(Long id){

        if (operationRepository.findById(id).isPresent()) {
            operationRepository.deleteById(id);
            return new MapResponse().withSuccess(true)
            .withMessage("Suppression réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Cette enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> findAll(){

        List<Operation> operations = operationRepository.findAll();
        return new MapResponse().withSuccess(true)
        .withObject(operations)
        .withMessage(operations.size()+" enregistrements retrouvé").response();
    }

    public Map<String, Object> findByCompte(Long id){
        Optional<Compte> compte = CompteRepository.findById(id);
        if (compte.isPresent()) {
            List<Operation> operations = operationRepository.findByCompte_id(id);
            return new MapResponse().withSuccess(true)
            .withMessage(operations.size()+" enregistrement retrouvé")
            .withObject(compte.get()).withArrayObject(operations).response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Ce compte n'est plus dans la base").response();
        }
    }

    public Map<String, Object> findByCategory(Long id){
        Optional<CategoryCompte> compte = categoryCompteRepository.findById(id);
        if (compte.isPresent()) {
            List<Operation> operations = operationRepository.findByCategory_id(id);
            return new MapResponse().withSuccess(true).withObject(compte.get())
            .withArrayObject(operations)
            .withMessage(operations.size()+" enregistrement réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Ce compte n'est plus dans la base").response();
        }
    }
}
