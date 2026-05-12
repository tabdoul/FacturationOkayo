package com.okayo.facturation.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.okayo.facturation.dtos.FactureDTO;
import com.okayo.facturation.dtos.LigneFactureDTO;
import com.okayo.facturation.entities.Article;
import com.okayo.facturation.entities.Client;
import com.okayo.facturation.entities.Detail;
import com.okayo.facturation.entities.Emetteur;
import com.okayo.facturation.entities.Facture;
import com.okayo.facturation.repositories.ArticleRepository;
import com.okayo.facturation.repositories.ClientRepository;
import com.okayo.facturation.repositories.DetailRepository;
import com.okayo.facturation.repositories.EmetteurRepository;
import com.okayo.facturation.repositories.FactureRepository;

@Service
public class FactureService {
    private final FactureRepository factureRepository;
    private final ArticleRepository articleRepository;
    private final DetailRepository detailRepository;
    private final ClientRepository clientRepository;
    private final EmetteurRepository emetteurRepository;

    public FactureService(FactureRepository factureRepository, ArticleRepository articleRepository, DetailRepository detailRepository, ClientRepository clientRepository, EmetteurRepository emetteurRepository){
        this.factureRepository=factureRepository;
        this.articleRepository=articleRepository;
        this.detailRepository=detailRepository;
        this.clientRepository=clientRepository;
        this.emetteurRepository=emetteurRepository;
    }

    public List<Facture> getAll(){ return factureRepository.findAll(); }
    public Optional<Facture> getById(Integer id){ return factureRepository.findById(id); }

    @Transactional
    public Facture create(FactureDTO dto){
        if(dto.ref_facture == null || dto.ref_facture.isBlank()){
            throw new IllegalArgumentException("La référence de facture (ref_facture) est obligatoire");
        }
        if(dto.date_facturation == null || dto.date_facturation.isBlank()){
            throw new IllegalArgumentException("La date de facturation (date_facturation) est obligatoire");
        }
        if(dto.date_echeance == null || dto.date_echeance.isBlank()){
            throw new IllegalArgumentException("La date d'échéance (date_echeance) est obligatoire");
        }
        if(dto.id_client == null){
            throw new IllegalArgumentException("L'ID du client (id_client) est obligatoire");
        }
        if(dto.id_emetteur == null){
            throw new IllegalArgumentException("L'ID de l'émetteur (id_emetteur) est obligatoire");
        }
        
        Facture f = new Facture();
        f.setRef_facture(dto.ref_facture);
        f.setDate_facturation(dto.date_facturation);
        f.setDate_echeance(dto.date_echeance);
        
        Client c = clientRepository.findById(dto.id_client)
            .orElseThrow(() -> new IllegalArgumentException("Client avec l'ID " + dto.id_client + " introuvable"));
        f.setClient(c);
        
        Emetteur e = emetteurRepository.findById(dto.id_emetteur)
            .orElseThrow(() -> new IllegalArgumentException("Émetteur avec l'ID " + dto.id_emetteur + " introuvable"));
        f.setEmetteur(e);
        
        f = factureRepository.save(f);

        if(dto.lignes != null && !dto.lignes.isEmpty()){
            List<Detail> details = new ArrayList<>();
            for(LigneFactureDTO l : dto.lignes){
                if(l.articleId == null){
                    throw new IllegalArgumentException("L'ID de l'article (articleId) est obligatoire dans les lignes de facture");
                }
                if(l.quantite == null || l.quantite <= 0){
                    throw new IllegalArgumentException("La quantité doit être positive pour l'article " + l.articleId);
                }
                
                Article a = articleRepository.findById(l.articleId)
                    .orElseThrow(() -> new IllegalArgumentException("Article avec l'ID " + l.articleId + " introuvable"));
                Detail d = new Detail();
                d.setFacture(f);
                d.setArticle(a);
                d.setQuantite(l.quantite);
                d.setNom_article(a.getCode_article());
                d.setPrix_unitaire("0");
                d.setTaux_tva("0");
                d.setTotal_ht("0");
                d.setTotal_ttc("0");
                detailRepository.save(d);
                details.add(d);
            }
            f.setDetails(details);
        }
        return f;
    }

    public Facture updateEcheance(Integer id, String newDate){
        Facture f = factureRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Facture not found"));
        f.setDate_echeance(newDate);
        return factureRepository.save(f);
    }
}