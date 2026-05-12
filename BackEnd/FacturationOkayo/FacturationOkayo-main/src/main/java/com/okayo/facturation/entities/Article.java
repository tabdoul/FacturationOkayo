package com.okayo.facturation.entities;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Article {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_article;
    @Column(nullable=false, unique=true)
    private String code_article;
    private String description;
    @JsonManagedReference(value="article-caracteristiques")
@OneToMany(mappedBy="article",fetch = FetchType.EAGER)
    private List<Caracteristique> caracteristiques = new ArrayList<>();
    @JsonManagedReference(value="article-details")
@OneToMany(mappedBy="article",fetch = FetchType.EAGER)
    private List<Detail> details = new ArrayList<>();

    public Article() {}
    public Article(Integer id_article, String code_article, String description) {
        this.id_article = id_article; this.code_article = code_article; this.description = description;
    }
    public Integer getId_article(){return id_article;} public void setId_article(Integer v){this.id_article=v;}
    public String getCode_article(){return code_article;} public void setCode_article(String v){this.code_article=v;}
    public String getDescription(){return description;} public void setDescription(String v){this.description=v;}
    public List<Caracteristique> getCaracteristiques(){return caracteristiques;} public void setCaracteristiques(List<Caracteristique> v){this.caracteristiques=v;}
    public List<Detail> getDetails(){return details;} public void setDetails(List<Detail> v){this.details=v;}
}