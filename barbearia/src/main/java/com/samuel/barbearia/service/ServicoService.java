package com.samuel.barbearia.service;

import com.samuel.barbearia.dto.ServicoDto;
import com.samuel.barbearia.model.Funcionario;
import com.samuel.barbearia.model.Servico;
import com.samuel.barbearia.repository.ServicoRepository;
import org.assertj.core.util.Sets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.JmxMetadataUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public ServicoDto save(ServicoDto servicoDto) {
        Servico servico = this.convertToEntity(servicoDto);
        servicoRepository.save(servico);
        return this.convertToDto(servico);
    }

    public ServicoDto findById(int id) {
        Servico servico = servicoRepository.findById(id).orElse(null);
        if(servico != null){
            return this.convertToDto(servico);
        }
        return null;
    }

    public List<ServicoDto> findAll() {
        List<Servico> servicos = servicoRepository.findAll();
        return this.convertToDto(servicos);
    }

    public void deleteById(Integer id) {
        servicoRepository.deleteById(id);

    }

    private ServicoDto convertToDto(Servico servico) {
        ServicoDto servicoDto = modelMapper.map(servico,ServicoDto.class);
        return servicoDto;
    }

    private Servico convertToEntity(ServicoDto servicoDto) {
        Servico servico = modelMapper.map(servicoDto,Servico.class);
        return servico;
    }

    private List<ServicoDto> convertToDto(List<Servico> servico) {
        List<ServicoDto> servicoDtos = servico
                .stream()
                .map(servico1 -> modelMapper
                        .map(servico1,ServicoDto.class))
                .collect(Collectors.toList());
        return servicoDtos;
    }
}
