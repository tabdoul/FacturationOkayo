package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Emetteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmetteurRepository extends JpaRepository<Emetteur, Integer> {
}