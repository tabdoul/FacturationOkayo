package com.okayo.facturation.controllers;

import com.okayo.facturation.dtos.ClientDTO;
import com.okayo.facturation.entities.Client;
import com.okayo.facturation.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientControlleur {
    private final ClientService service;
    public ClientControlleur(ClientService service){ this.service=service; }

    @GetMapping
    public ResponseEntity<List<Client>> getAll(){ return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public Optional<Client> getOne(@PathVariable Integer id){ return service.getById(id); }

    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto){
        Client c = service.create(dto);
        return ResponseEntity.created(URI.create("/clients/"+c.getId_Client())).body(c);
    }
}