package com.okayo.facturation.services;

import com.okayo.facturation.dtos.*;
import com.okayo.facturation.entities.*;
import com.okayo.facturation.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FactureService {
    private final FactureRepository factureRepository;
    private final ArticleRepository articleRepository;
    private final DetailRepository detailRepository;

    public FactureService(FactureRepository factureRepository, ArticleRepository articleRepository, DetailRepository detailRepository){
        this.factureRepository=factureRepository;
        this.articleRepository=articleRepository;
        this.detailRepository=detailRepository;
    }

    public List<Facture> getAll(){ return factureRepository.findAll(); }
    public Optional<Facture> getById(Integer id){ return factureRepository.findById(id); }

    @Transactional
    public Facture create(FactureDTO dto){
        Facture f = new Facture();
        f.setRef_facture(dto.ref_facture);
        f.setDate_facturation(dto.date_facturation);
        f.setDate_echeance(dto.date_echeance);
        f = factureRepository.save(f);

        if(dto.lignes != null){
            List<Detail> details = new ArrayList<>();
            for(LigneFactureDTO l : dto.lignes){
                Article a = articleRepository.findById(l.articleId).orElseThrow(() -> new IllegalArgumentException("Article not found: "+l.articleId));
                Detail d = new Detail();
                d.setFacture(f);
                d.setArticle(a);
                d.setQuantite(l.quantite != null ? l.quantite : 1);
                // fallback values; real price logic may use Caracteristique
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