package com.okayo.facturation.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.okayo.facturation.entities.Utilisateur;
import com.okayo.facturation.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Utilisateur register(String username, String password, String role) {
        Utilisateur u = new Utilisateur(username, encoder.encode(password), role);
        return utilisateurRepository.save(u);
    }

    public boolean authenticate(String username, String password) {
        return utilisateurRepository.findByUsername(username)
                .map(u -> encoder.matches(password, u.getPassword()))
                .orElse(false);
    }
}