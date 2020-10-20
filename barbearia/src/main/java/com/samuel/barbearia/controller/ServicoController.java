package com.samuel.barbearia.controller;

import com.samuel.barbearia.model.Servico;
import com.samuel.barbearia.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servicos")
public class ServicoController {
    final
    ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> findAll() {
        return new ResponseEntity<List<Servico>>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Servico> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(servicoService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servico> save(@RequestBody Servico entity) {
        return new ResponseEntity<Servico>(servicoService.save(entity),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Servico> update(@RequestBody Servico entity) {
        return new ResponseEntity<Servico>(servicoService.save(entity),HttpStatus.OK);
    }
}
