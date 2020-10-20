package com.samuel.barbearia.controller;

import com.samuel.barbearia.model.Funcionario;
import com.samuel.barbearia.model.Pessoa;
import com.samuel.barbearia.service.FuncionarioService;
import com.samuel.barbearia.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("funcionarios")
public class FuncionarioController {
    final
    FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) { this.funcionarioService = funcionarioService;}

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return new ResponseEntity<List<Funcionario>>(funcionarioService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(funcionarioService.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario entity) {
        return new ResponseEntity<Funcionario>(funcionarioService.save(entity),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        funcionarioService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Funcionario> update(@RequestBody Funcionario entity) {
        return new ResponseEntity<Funcionario>(funcionarioService.save(entity),HttpStatus.OK);
    }
}
