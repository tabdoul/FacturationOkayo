package com.okayo.facturation.entities;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Detail {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detail;
    private String nom_article;
    private String prix_unitaire;
    private Integer quantite;
    private String taux_tva;
    private String total_ht;
    private String total_ttc;

    @ManyToOne @JoinColumn(name="id_facture", nullable=false)
@JsonBackReference(value="facture-details")
    private Facture facture;

    @ManyToOne @JoinColumn(name="id_article", nullable=false)
@JsonBackReference(value="article-details")
    private Article article;

    public Detail(){}
    public Detail(Integer id, String nom, String pu, Integer q, String tva, String tht, String tttc, Facture f, Article a){
        this.id_detail=id; this.nom_article=nom; this.prix_unitaire=pu; this.quantite=q; this.taux_tva=tva; this.total_ht=tht; this.total_ttc=tttc; this.facture=f; this.article=a;
    }

    public Integer getId_detail(){return id_detail;} public void setId_detail(Integer v){this.id_detail=v;}
    public String getNom_article(){return nom_article;} public void setNom_article(String v){this.nom_article=v;}
    public String getPrix_unitaire(){return prix_unitaire;} public void setPrix_unitaire(String v){this.prix_unitaire=v;}
    public Integer getQuantite(){return quantite;} public void setQuantite(Integer v){this.quantite=v;}
    public String getTaux_tva(){return taux_tva;} public void setTaux_tva(String v){this.taux_tva=v;}
    public String getTotal_ht(){return total_ht;} public void setTotal_ht(String v){this.total_ht=v;}
    public String getTotal_ttc(){return total_ttc;} public void setTotal_ttc(String v){this.total_ttc=v;}
    public Facture getFacture(){return facture;} public void setFacture(Facture v){this.facture=v;}
    public Article getArticle(){return article;} public void setArticle(Article v){this.article=v;}
}