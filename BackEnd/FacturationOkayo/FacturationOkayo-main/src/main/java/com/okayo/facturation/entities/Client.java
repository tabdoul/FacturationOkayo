package com.okayo.facturation.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Client;
    @Column(nullable=false, unique=true)
    private String code_client;
    private String adresse_client;
    private String cp_client;
    private String ville_client;
    @JsonManagedReference(value="client-factures")
@OneToMany(mappedBy="client")
    private List<Facture> factures = new ArrayList<>();

    public Client(){}
    public Client(Integer id, String code, String adr, String cp, String ville){
        this.id_Client=id; this.code_client=code; this.adresse_client=adr; this.cp_client=cp; this.ville_client=ville;
    }
    public Integer getId_Client(){return id_Client;} public void setId_Client(Integer v){this.id_Client=v;}
    public String getCode_client(){return code_client;} public void setCode_client(String v){this.code_client=v;}
    public String getAdresse_client(){return adresse_client;} public void setAdresse_client(String v){this.adresse_client=v;}
    public String getCp_client(){return cp_client;} public void setCp_client(String v){this.cp_client=v;}
    public String getVille_client(){return ville_client;} public void setVille_client(String v){this.ville_client=v;}
    public List<Facture> getFactures(){return factures;} public void setFactures(List<Facture> v){this.factures=v;}
}