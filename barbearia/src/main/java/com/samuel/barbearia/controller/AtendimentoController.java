package com.samuel.barbearia.controller;

import com.samuel.barbearia.model.Atendimento;
import com.samuel.barbearia.service.AtendimentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendimentos")
public class AtendimentoController {

    final
    AtendimentoService atendimentoService;

    public AtendimentoController(AtendimentoService atendimentoService) { this.atendimentoService = atendimentoService;}

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll() {
        return new ResponseEntity<List<Atendimento>>(atendimentoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(atendimentoService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Atendimento> save(@RequestBody Atendimento entity) {
        return new ResponseEntity<Atendimento>(atendimentoService.save(entity),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        atendimentoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Atendimento> update(@RequestBody Atendimento entity) {
        return new ResponseEntity<Atendimento>(atendimentoService.save(entity),HttpStatus.OK);
    }
}
