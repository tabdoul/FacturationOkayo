package com.okayo.facturation.dtos;

import java.util.List;

public class FactureDTO {
    public String ref_facture;
    public String date_facturation;
    public String date_echeance;
    public Integer id_client;
    public Integer id_emetteur;
    public List<LigneFactureDTO> lignes;
}