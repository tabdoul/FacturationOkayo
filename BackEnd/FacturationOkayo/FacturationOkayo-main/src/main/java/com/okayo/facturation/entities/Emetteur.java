package com.okayo.facturation.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Emetteur {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_emetteur;
    @Column(nullable=false)
    private String nom_emetteur;
    private String adresse_emetteur;
    private String cp_emetteur;
    private String ville_emetteur;
    private String iban_emetteur;
    private String bic;
    @JsonManagedReference(value="emetteur-factures")
@OneToMany(mappedBy="emetteur")
    private List<Facture> factures = new ArrayList<>();

    public Emetteur(){}
    public Emetteur(Integer id, String nom, String adr, String cp, String ville, String iban, String bic){
        this.id_emetteur=id; this.nom_emetteur=nom; this.adresse_emetteur=adr; this.cp_emetteur=cp; this.ville_emetteur=ville; this.iban_emetteur=iban; this.bic=bic;
    }
    public Integer getId_emetteur(){return id_emetteur;} public void setId_emetteur(Integer v){this.id_emetteur=v;}
    public String getNom_emetteur(){return nom_emetteur;} public void setNom_emetteur(String v){this.nom_emetteur=v;}
    public String getAdresse_emetteur(){return adresse_emetteur;} public void setAdresse_emetteur(String v){this.adresse_emetteur=v;}
    public String getCp_emetteur(){return cp_emetteur;} public void setCp_emetteur(String v){this.cp_emetteur=v;}
    public String getVille_emetteur(){return ville_emetteur;} public void setVille_emetteur(String v){this.ville_emetteur=v;}
    public String getIban_emetteur(){return iban_emetteur;} public void setIban_emetteur(String v){this.iban_emetteur=v;}
    public String getBic(){return bic;} public void setBic(String v){this.bic=v;}
    public List<Facture> getFactures(){return factures;} public void setFactures(List<Facture> v){this.factures=v;}
}