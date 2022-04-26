package com.projet.ferme.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.projet.ferme.entity.Operation;
import com.projet.ferme.entity.PrimaryCompte;
import com.projet.ferme.entity.SecondaryCompte;
import com.projet.ferme.repository.OperationRepository;
import com.projet.ferme.repository.PrimaryCompteRepository;
import com.projet.ferme.repository.SecondaryCompteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperationService {
    
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private SecondaryCompteRepository secondaryCompteRepository;
    @Autowired
    private PrimaryCompteRepository primaryCompteRepository;

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
        .withMessage(operations.size()+" enregistrements retrouvé").response();
    }

    public Map<String, Object> findBySecondary(Long id){
        Optional<SecondaryCompte> compte = secondaryCompteRepository.findById(id);
        if (compte.isPresent()) {
            List<Operation> operations = operationRepository.findBySecondary_id(id);
            return new MapResponse().withSuccess(true)
            .withMessage(operations.size()+" enregistrement retrouvé")
            .withObject(compte.get()).withArrayObject(operations).response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Ce compte n'est plus dans la base").response();
        }
    }

    public Map<String, Object> findByPrimary(Long id){
        Optional<PrimaryCompte> compte = primaryCompteRepository.findById(id);
        if (compte.isPresent()) {
            List<SecondaryCompte> comptes = secondaryCompteRepository.findByPrimary_id(id);
            List<Operation> operations = operationRepository.findAll();
            operations = operations.stream().filter(object -> comptes.contains(object.getSecondary()))
            .collect(Collectors.toList());
            return new MapResponse().withSuccess(true).withObject(compte.get())
            .withArrayObject(comptes).withChildArrayObject(operations)
            .withMessage(operations.size()+" enregistrement réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
            .withMessage("Ce compte n'est plus dans la base").response();
        }
    }
}
