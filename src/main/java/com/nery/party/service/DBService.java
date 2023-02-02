package com.nery.party.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.party.domain.Party;
import com.nery.party.domain.Servico;
import com.nery.party.repositories.PartyRepository;
import com.nery.party.repositories.ServiceRepository;

@Service
public class DBService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private PartyRepository partyRepository;

    public void instaciaBasedeDados() {    
        Party party1 = new Party(null, "Festa do Matheus", "Matheus Nery", "Uma surpresinha para o Matheus", 2000.50f);
        Party party2 = new Party(null, "Festa do Lucas", "Lucas Nery", "Uma surpresinha para o Lucas", 2000.50f);
        Party party3 = new Party(null, "Festa do Mikael", "Mikael Nery", "Uma surpresinha para o Mikael", 2000.50f);

        Servico serv1 = new Servico(null, "Comes e Bebes", 1350.1f, party1);
        Servico serv2 = new Servico(null, "Decoração da festa", 500.00f, party1);
        Servico serv3 = new Servico(null, "Mesas e Cadeiras", 200.00f, party3);

        party1.getServicos().addAll(Arrays.asList(serv1, serv2));
        party3.getServicos().addAll(Arrays.asList(serv3));

        this.partyRepository.saveAll(Arrays.asList(party1, party2, party3));
        this.serviceRepository.saveAll(Arrays.asList(serv1, serv2, serv3));        
    }
}
