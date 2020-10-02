package com.samuel.barbearia.service;

import com.samuel.barbearia.model.Servico;
import com.samuel.barbearia.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico save(Servico entity) {
        return servicoRepository.save(entity);
    }

    public Optional<Servico> findById(int id) {
        return servicoRepository.findById(id);
    }

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public void deleteById(Integer id) {
        servicoRepository.deleteById(id);

    }
}
