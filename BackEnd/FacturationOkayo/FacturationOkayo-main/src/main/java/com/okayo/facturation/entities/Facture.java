package com.okayo.facturation.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.*;

@Entity
public class Facture {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_facture;
    @Column(nullable=false, unique=true)
    private String ref_facture;
    private String date_facturation;
    private String date_echeance;

    @ManyToOne @JoinColumn(name="id_emetteur")
@JsonBackReference(value="emetteur-factures")
    private Emetteur emetteur;

    @ManyToOne @JoinColumn(name="id_Client")
@JsonBackReference(value="client-factures")
    private Client client;

    @JsonManagedReference(value="facture-details")
@OneToMany(mappedBy="facture", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Detail> details = new ArrayList<>();

    public Facture(){}
    public Facture(Integer id, String ref, String df, String de, Emetteur em, Client cl){
        this.id_facture=id; this.ref_facture=ref; this.date_facturation=df; this.date_echeance=de; this.emetteur=em; this.client=cl;
    }

    public Integer getId_facture(){return id_facture;} public void setId_facture(Integer v){this.id_facture=v;}
    public String getRef_facture(){return ref_facture;} public void setRef_facture(String v){this.ref_facture=v;}
    public String getDate_facturation(){return date_facturation;} public void setDate_facturation(String v){this.date_facturation=v;}
    public String getDate_echeance(){return date_echeance;} public void setDate_echeance(String v){this.date_echeance=v;}
    public Emetteur getEmetteur(){return emetteur;} public void setEmetteur(Emetteur v){this.emetteur=v;}
    public Client getClient(){return client;} public void setClient(Client v){this.client=v;}
    public List<Detail> getDetails(){return details;} public void setDetails(List<Detail> v){this.details=v;}
}