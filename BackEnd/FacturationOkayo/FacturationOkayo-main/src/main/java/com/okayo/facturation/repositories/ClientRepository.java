package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}