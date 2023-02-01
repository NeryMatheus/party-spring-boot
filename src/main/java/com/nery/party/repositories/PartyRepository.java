package com.nery.party.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nery.party.domain.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    
}
