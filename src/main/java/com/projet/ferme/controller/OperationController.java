package com.projet.ferme.controller;

import java.util.Map;

import com.projet.ferme.entity.Operation;
import com.projet.ferme.service.OperationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {
    
    @Autowired
    private OperationService operationService;

    @RequestMapping(value = "api/v1/operation", method = RequestMethod.POST)
    public Map<String, Object> addOperation(@RequestBody Operation operation) {
        return operationService.addOperation(operation);
    }

    @RequestMapping(value = "api/v1/operation", method = RequestMethod.PUT)
    public Map<String, Object> updateOperation(@RequestBody Operation operation) {
        return operationService.updateOperation(operation);
    }

    @RequestMapping(value = "api/v1/operation/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteOperation(@PathVariable("id") Long id){
        return operationService.deleteOperation(id);
    }

    @RequestMapping(value = "api/v1/operation/category/{id}", method = RequestMethod.GET)
    public Map<String, Object> getBySecondary(@PathVariable("id") Long id){
        return operationService.findByCategory(id);
    }

    @RequestMapping(value = "api/v1/operation/compte/{id}", method = RequestMethod.GET)
    public Map<String, Object> getByCompte(@PathVariable("id") Long id){
        return operationService.findByCompte(id);
    }

    @RequestMapping(value = "api/v1/operation", method = RequestMethod.GET)
    public Map<String, Object> getAll(){
        return operationService.findAll();
    }
}