package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristiqueRepository extends JpaRepository<Caracteristique, com.okayo.facturation.entities.CaracteristiqueId> {
}