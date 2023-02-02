package com.nery.party.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nery.party.domain.Servico;
import com.nery.party.service.ServicoService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/servicos")
public class ServicoResource {

    @Autowired
    private ServicoService servicoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id) {
        Servico serv = servicoService.findById(id);
        return ResponseEntity.ok().body(serv);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        List<Servico> list = servicoService.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @PostMapping
    public ResponseEntity<Servico> create(@Valid @RequestBody Servico serv) {
        serv = servicoService.create(serv);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(serv.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Servico> update(@Valid @PathVariable Integer id, @RequestBody Servico serv) {
        Servico newServ = servicoService.update(id, serv);
        return ResponseEntity.ok().body(newServ);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        servicoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
