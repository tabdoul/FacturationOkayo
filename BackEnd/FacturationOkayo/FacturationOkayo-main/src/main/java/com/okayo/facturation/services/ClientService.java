package com.okayo.facturation.services;

import com.okayo.facturation.dtos.ClientDTO;
import com.okayo.facturation.entities.Client;
import com.okayo.facturation.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){ this.clientRepository = clientRepository; }

    public List<Client> getAll(){ return clientRepository.findAll(); }
    public Optional<Client> getById(Integer id){ return clientRepository.findById(id); }

    public Client create(ClientDTO dto){
        Client c = new Client();
        c.setCode_client(dto.code_client);
        c.setAdresse_client(dto.adresse_client);
        c.setCp_client(dto.cp_client);
        c.setVille_client(dto.ville_client);
        return clientRepository.save(c);
    }
}