package com.okayo.facturation.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Caracteristique {
    @EmbeddedId
    private CaracteristiqueId idCaracteristique;

    @MapsId("id_article")
    @JsonBackReference(value="article-caracteristiques")
@ManyToOne
    @JoinColumn(name="id_article")
    private Article article;

    private String nom;
    private Float prix;
    private Float tva;
    private LocalDate date_fin;

    public Caracteristique(){}
    public Caracteristique(CaracteristiqueId id, Article article, String nom, Float prix, Float tva, LocalDate date_fin){
        this.idCaracteristique=id; this.article=article; this.nom=nom; this.prix=prix; this.tva=tva; this.date_fin=date_fin;
    }

    public CaracteristiqueId getIdCaracteristique(){return idCaracteristique;} public void setIdCaracteristique(CaracteristiqueId v){this.idCaracteristique=v;}
    public Article getArticle(){return article;} public void setArticle(Article v){this.article=v;}
    public String getNom(){return nom;} public void setNom(String v){this.nom=v;}
    public Float getPrix(){return prix;} public void setPrix(Float v){this.prix=v;}
    public Float getTva(){return tva;} public void setTva(Float v){this.tva=v;}
    public LocalDate getDate_fin(){return date_fin;} public void setDate_fin(LocalDate v){this.date_fin=v;}
}