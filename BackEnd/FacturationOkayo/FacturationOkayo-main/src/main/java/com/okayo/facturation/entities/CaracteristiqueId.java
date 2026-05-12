package com.okayo.facturation.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class CaracteristiqueId implements Serializable {
    private Integer id_article;
    private LocalDate date_debut;

    public CaracteristiqueId(){}
    public CaracteristiqueId(Integer id_article, LocalDate date_debut){
        this.id_article=id_article; this.date_debut=date_debut;
    }
    public Integer getId_article(){return id_article;} public void setId_article(Integer v){this.id_article=v;}
    public LocalDate getDate_debut(){return date_debut;} public void setDate_debut(LocalDate v){this.date_debut=v;}

    @Override public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof CaracteristiqueId)) return false;
        CaracteristiqueId that = (CaracteristiqueId)o;
        return Objects.equals(id_article, that.id_article) && Objects.equals(date_debut, that.date_debut);
    }
    @Override public int hashCode(){ return Objects.hash(id_article, date_debut); }
}