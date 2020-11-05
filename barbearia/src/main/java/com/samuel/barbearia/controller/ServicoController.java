package com.samuel.barbearia.controller;

import com.samuel.barbearia.dto.ServicoDto;
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
    public ResponseEntity<List<ServicoDto>> findAll() {
        return new ResponseEntity<List<ServicoDto>>(servicoService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ServicoDto> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(servicoService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ServicoDto> save(@RequestBody ServicoDto servicoDto) {
        return new ResponseEntity<ServicoDto>(servicoService.save(servicoDto),HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        servicoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ServicoDto> update(@RequestBody ServicoDto servicoDto) {
        return new ResponseEntity<ServicoDto>(servicoService.save(servicoDto),HttpStatus.OK);
    }
}
