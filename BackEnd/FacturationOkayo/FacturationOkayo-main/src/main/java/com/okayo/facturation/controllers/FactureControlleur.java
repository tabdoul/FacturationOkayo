package com.okayo.facturation.controllers;

import com.okayo.facturation.dtos.FactureDTO;
import com.okayo.facturation.entities.Facture;
import com.okayo.facturation.services.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/factures")
public class FactureControlleur {

    private final FactureService factureService;

    public FactureControlleur(FactureService factureService) {
        this.factureService = factureService;
    }

    @GetMapping
    public ResponseEntity<List<Facture>> getAllFactures() {
        return ResponseEntity.ok(factureService.getAll());
    }

    @GetMapping("/{id}")
    public Optional<Facture> getFactureById(@PathVariable Integer id) {
        return factureService.getById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Facture> createFacture(@RequestBody FactureDTO dto) {
        Facture f = factureService.create(dto);
        return ResponseEntity.created(URI.create("/factures/" + f.getId_facture())).body(f);
    }

    @PutMapping("/{id}/echeance")
    public ResponseEntity<Facture> updateEcheance(@PathVariable Integer id, @RequestParam String newDateEcheance) {
        Facture f = factureService.updateEcheance(id, newDateEcheance);
        return ResponseEntity.ok(f);
    }
}