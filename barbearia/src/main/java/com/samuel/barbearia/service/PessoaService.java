package com.samuel.barbearia.service;

import com.samuel.barbearia.model.Pessoa;
import com.samuel.barbearia.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa save(Pessoa entity) {
        return pessoaRepository.save(entity);
    }

    public Optional<Pessoa> findById(int id) {
        return pessoaRepository.findById(id);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public void deleteById(Integer id) {
        pessoaRepository.deleteById(id);

    }
}
