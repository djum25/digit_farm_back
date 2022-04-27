package com.projet.ferme.controller;

import java.util.Map;

import com.projet.ferme.entity.PrimaryCompte;
import com.projet.ferme.entity.SecondaryCompte;
import com.projet.ferme.service.PrimarySecondaryCompteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class CompteController {
    
    @Autowired
    private PrimarySecondaryCompteService compteService;

    @RequestMapping(value="/api/v1/compte/primary", method=RequestMethod.POST)
    public Map<String,Object> addPrimary(@RequestBody PrimaryCompte compte) {
        return compteService.addPrimary(compte);
    }

    @RequestMapping(value="/api/v1/compte/secondary", method=RequestMethod.POST)
    public Map<String,Object> addSecondary(@RequestBody SecondaryCompte compte) {
        return compteService.addSecondary(compte);
    }

    @RequestMapping(value = "/api/v1/compte/primary", method = RequestMethod.PUT)
    public Map<String,Object> putPrimary(@RequestBody PrimaryCompte compte){
        return compteService.updatePrimary(compte);
    }

    @RequestMapping(value = "/api/v1/compte/secondary", method = RequestMethod.PUT)
    public Map<String,Object> putSecondary(@RequestBody SecondaryCompte compte){
        return compteService.updateSecondary(compte);
    }

    @RequestMapping(value = "/api/v1/compte/primary", method = RequestMethod.GET)
    public Map<String, Object> getPrimary(){
        return compteService.findAllPrimary();
    }
    
    @RequestMapping(value = "/api/v1/compte/secondary", method = RequestMethod.GET)
    public Map<String, Object> getSecondary(){
        return compteService.findAllSecondary();
    }

    @RequestMapping(value = "/api/v1/compte/secondaryById/{id}", method = RequestMethod.GET)
    public Map<String, Object> getCompteSecondaryByPrimaryCompteId(@PathVariable("id") Long id){
        return compteService.findSecondaryByPrimary(id);
    }

    @RequestMapping(value = "/api/v1/compte/primary/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> getPrimary(@PathVariable("id") Long id){
        return compteService.deletePrimary(id);
    }
    
    @RequestMapping(value = "/api/v1/compte/secondary/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> getSecondary(@PathVariable("id") Long id){
        return compteService.deleteSecondary(id);
    }
}
