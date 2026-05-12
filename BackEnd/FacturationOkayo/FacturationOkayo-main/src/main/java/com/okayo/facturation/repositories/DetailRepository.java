package com.okayo.facturation.repositories;

import com.okayo.facturation.entities.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Integer> {
}