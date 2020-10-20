package com.samuel.barbearia.service;

import com.samuel.barbearia.model.Atendimento;
import com.samuel.barbearia.model.Funcionario;
import com.samuel.barbearia.repository.AtendimentoRepository;
import com.samuel.barbearia.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario save(Funcionario entity) {
        return funcionarioRepository.save(entity);
    }

    public Optional<Funcionario> findById(int id) {
        return funcionarioRepository.findById(id);
    }

    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

    public void deleteById(Integer id) {
        funcionarioRepository.deleteById(id);
    }
}
