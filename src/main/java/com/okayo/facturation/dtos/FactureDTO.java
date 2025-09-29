package com.okayo.facturation.dtos;

import java.util.List;

public class FactureDTO {
    public String ref_facture;
    public String date_facturation;
    public String date_echeance;
    public List<LigneFactureDTO> lignes;
}