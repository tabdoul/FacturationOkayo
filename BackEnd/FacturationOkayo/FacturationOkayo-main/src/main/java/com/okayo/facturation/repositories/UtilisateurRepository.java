package com.okayo.facturation.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.okayo.facturation.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findByUsername(String username);
}