package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
}