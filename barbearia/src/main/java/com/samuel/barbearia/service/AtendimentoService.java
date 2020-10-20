package com.samuel.barbearia.service;

import com.samuel.barbearia.model.Atendimento;
import com.samuel.barbearia.repository.AtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    public Atendimento save(Atendimento entity) {
        return atendimentoRepository.save(entity);
    }

    public Optional<Atendimento> findById(int id) {
        return atendimentoRepository.findById(id);
    }

    public List<Atendimento> findAll() {
        return atendimentoRepository.findAll();
    }

    public void deleteById(Integer id) {
        atendimentoRepository.deleteById(id);
    }
}
