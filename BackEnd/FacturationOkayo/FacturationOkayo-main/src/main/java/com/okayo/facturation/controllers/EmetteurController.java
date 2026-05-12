package com.okayo.facturation.controllers;

import com.okayo.facturation.dtos.EmetteurDTO;
import com.okayo.facturation.entities.Emetteur;
import com.okayo.facturation.services.EmetteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emetteurs")
public class EmetteurController {
    private final EmetteurService service;
    public EmetteurController(EmetteurService service){ this.service=service; }

    @GetMapping
    public ResponseEntity<List<Emetteur>> getAll(){ return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public Optional<Emetteur> getById(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping("/create")
    public ResponseEntity<Emetteur> create(@RequestBody EmetteurDTO dto){
        Emetteur e = service.create(dto);
        return ResponseEntity.created(URI.create("/emetteurs/"+e.getId_emetteur())).body(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emetteur> update(@PathVariable Integer id, @RequestBody EmetteurDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}