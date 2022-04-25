package com.projet.ferme.service;

import java.util.List;
import java.util.Map;

import com.projet.ferme.entity.PrimaryCompte;
import com.projet.ferme.entity.SecondaryCompte;
import com.projet.ferme.repository.PrimaryCompteRepository;
import com.projet.ferme.repository.SecondaryCompteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrimarySecondaryCompteService {

    @Autowired
    private PrimaryCompteRepository primaryCompteRepository;

    @Autowired
    private SecondaryCompteRepository secondaryCompteRepository;

    public Map<String, Object> addPrimary(PrimaryCompte compte) {

        PrimaryCompte primaryCompte = primaryCompteRepository.save(compte);

        if (primaryCompte != null) {
            return new MapResponse().withSuccess(true)
                    .withMessage("Enregistrement réussit").withObject(primaryCompte).response();
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Enregistrement échoué").response();
        }
    }

    public Map<String, Object> addSecondary(SecondaryCompte compte) {

        SecondaryCompte secondaryCompte = secondaryCompteRepository.save(compte);

        if (secondaryCompte != null) {
            return new MapResponse().withSuccess(true).withMessage("Enregistrement réussit")
                    .withObject(secondaryCompte).response();
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Enregistrement échoué").response();
        }
    }

    public Map<String, Object> updatePrimary(PrimaryCompte compte) {

        if (primaryCompteRepository.findById(compte.getId()).isPresent()) {
            PrimaryCompte primaryCompte = primaryCompteRepository.save(compte);

            if (primaryCompte != null) {
                return new MapResponse().withSuccess(true)
                        .withMessage("Enregistrement réussit").withObject(primaryCompte).response();
            } else {
                return new MapResponse().withSuccess(false)
                        .withMessage("Enregistrement échoué").response();
            }
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Votre enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> updateSecondary(SecondaryCompte compte) {

        if (secondaryCompteRepository.findById(compte.getId()).isPresent()) {
            SecondaryCompte secondaryCompte = secondaryCompteRepository.save(compte);

            if (secondaryCompte != null) {
                return new MapResponse().withSuccess(true).withMessage("Enregistrement réussit")
                        .withObject(secondaryCompte).response();
            } else {
                return new MapResponse().withSuccess(false)
                        .withMessage("Enregistrement échoué").response();
            }
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Votre enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> deletePrimary(Long id){
        if (primaryCompteRepository.findById(id).isPresent()) {
            return new MapResponse().withSuccess(true)
                    .withMessage("Suppression réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Votre enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> deleteSecondary(Long id){
        if (secondaryCompteRepository.findById(id).isPresent()) {
            return new MapResponse().withSuccess(true)
                    .withMessage("Suppression réussit").response();
        } else {
            return new MapResponse().withSuccess(false)
                    .withMessage("Votre enregistrement n'est plus dans la base").response();
        }
    }

    public Map<String, Object> findAllPrimary(){
        List<PrimaryCompte> comptes = primaryCompteRepository.findAll();
        return new MapResponse().withSuccess(true).withMessage("Enregistrements trouvés "+comptes.size())
        .withObject(comptes).response();
    }

    public Map<String, Object> findAllSecondary(){
        List<SecondaryCompte> comptes = secondaryCompteRepository.findAll();
        return new MapResponse().withSuccess(true).withMessage("Enregistrements trouvés "+comptes.size())
        .withObject(comptes).response();
    }
}
