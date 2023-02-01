package com.nery.party.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nery.party.domain.Servico;

@Repository
public interface ServiceRepository extends JpaRepository<Servico, Integer> {
    
}
