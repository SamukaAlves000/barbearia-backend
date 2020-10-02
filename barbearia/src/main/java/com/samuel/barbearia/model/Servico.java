package com.samuel.barbearia.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_SERVICO")
@Data
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private byte duracao;
}
