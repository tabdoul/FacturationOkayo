package com.okayo.facturation.services;

import com.okayo.facturation.dtos.ArticleDTO;
import com.okayo.facturation.entities.*;
import com.okayo.facturation.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CaracteristiqueRepository caracteristiqueRepository;

    public ArticleService(ArticleRepository articleRepository, CaracteristiqueRepository caracteristiqueRepository) {
        this.articleRepository = articleRepository;
        this.caracteristiqueRepository = caracteristiqueRepository;
    }

    public List<Article> getAllArticles(){ return articleRepository.findAll(); }

    public Optional<Article> getArticleById(Integer id){ return articleRepository.findById(id); }

    @Transactional
    public Article createArticle(ArticleDTO dto){
        Article a = new Article();
        a.setCode_article(dto.code_article);
        a.setDescription(dto.description);
        a = articleRepository.save(a);

        // create Caracteristique if provided
        if(dto.nom != null || dto.prix != null || dto.tva != null){
            CaracteristiqueId cid = new CaracteristiqueId(a.getId_article(),
                    dto.date_debut != null && !dto.date_debut.isBlank() ? LocalDate.parse(dto.date_debut) : LocalDate.now());
            Caracteristique c = new Caracteristique(cid, a, dto.nom, dto.prix, dto.tva,
                    (dto.date_fin != null && !dto.date_fin.isBlank()) ? LocalDate.parse(dto.date_fin) : null);
            caracteristiqueRepository.save(c);
        }
        return a;
    }
}