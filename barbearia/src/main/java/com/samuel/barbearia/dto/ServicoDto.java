package com.samuel.barbearia.dto;

import com.samuel.barbearia.model.Funcionario;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ServicoDto {

    private int id;
    private String descricao;
    private double preco;
    private byte duracao;
    private List<Funcionario> funcionarios;
}
