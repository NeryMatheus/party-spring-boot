package com.nery.party.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nery.party.domain.Servico;
import com.nery.party.repositories.ServiceRepository;

import jakarta.validation.Valid;

import com.nery.party.exceptions.ObjectNotFoundExceptions;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class ServicoService {

    @Autowired
    private ServiceRepository serviceRepository;

    public Servico findById(Integer id) {
        Optional<Servico> obj = serviceRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
                "Objeto não encontrado! Id: " + id + ". Tipo? " + Servico.class.getName(), null));
    }

    public List<Servico> findAll() {
        return serviceRepository.findAll();
    }

    public Servico create(Servico serv) {
        serv.setId(null);
        return serviceRepository.save(serv);
    }

    public Servico update(@Valid Integer id, Servico serv) {
        Servico servico = findById(id);
        servico.setDescricao(serv.getDescricao());
        servico.setPrice(serv.getPrice());

        return serviceRepository.save(servico);
    }

    public void delete(Integer id) {
        findById(id);
        try{
            serviceRepository.deleteById(id);
        }catch(org.springframework.dao.DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Serviço não pode ser excluída pois possui festas associadas!!");
        }
    }
}
