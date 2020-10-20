package com.samuel.barbearia.controller;

import com.samuel.barbearia.model.Pessoa;
import com.samuel.barbearia.service.PessoaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaController {

    final
    PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) { this.pessoaService = pessoaService;}

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return new ResponseEntity<List<Pessoa>>(pessoaService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(pessoaService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa entity) {
        return new ResponseEntity<Pessoa>(pessoaService.save(entity),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        pessoaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pessoa> update(@RequestBody Pessoa entity) {
        return new ResponseEntity<Pessoa>(pessoaService.save(entity),HttpStatus.OK);
    }
}
