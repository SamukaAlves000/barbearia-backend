package com.samuel.barbearia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_SERVICO")
@Data
public class Servico implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50, nullable = false)
    private String descricao;
    @Column(nullable = false)
    private double preco;
    @Column(nullable = false)
    private byte duracao;
    @JsonIgnore
    @ManyToMany(mappedBy = "servicos", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios;
    @ManyToMany(mappedBy = "servicos")
    @JsonIgnore
    private List<Atendimento> atendimentos;
}
