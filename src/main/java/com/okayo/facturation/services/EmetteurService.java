package com.okayo.facturation.services;

import com.okayo.facturation.dtos.EmetteurDTO;
import com.okayo.facturation.entities.Emetteur;
import com.okayo.facturation.repositories.EmetteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmetteurService {
    private final EmetteurRepository repo;
    public EmetteurService(EmetteurRepository repo){ this.repo=repo; }

    public List<Emetteur> getAll(){ return repo.findAll(); }
    public Optional<Emetteur> getById(Integer id){ return repo.findById(id); }

    public Emetteur create(EmetteurDTO dto){
        Emetteur e = new Emetteur();
        e.setNom_emetteur(dto.nom_emetteur);
        e.setAdresse_emetteur(dto.adresse_emetteur);
        e.setCp_emetteur(dto.cp_emetteur);
        e.setVille_emetteur(dto.ville_emetteur);
        e.setIban_emetteur(dto.iban_emetteur);
        e.setBic(dto.bic);
        return repo.save(e);
    }

    public Emetteur update(Integer id, EmetteurDTO dto){
        Emetteur e = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Emetteur not found"));
        if(dto.nom_emetteur!=null) e.setNom_emetteur(dto.nom_emetteur);
        if(dto.adresse_emetteur!=null) e.setAdresse_emetteur(dto.adresse_emetteur);
        if(dto.cp_emetteur!=null) e.setCp_emetteur(dto.cp_emetteur);
        if(dto.ville_emetteur!=null) e.setVille_emetteur(dto.ville_emetteur);
        if(dto.iban_emetteur!=null) e.setIban_emetteur(dto.iban_emetteur);
        if(dto.bic!=null) e.setBic(dto.bic);
        return repo.save(e);
    }

    public void delete(Integer id){
        Emetteur e = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Emetteur not found"));
        repo.delete(e);
    }
}