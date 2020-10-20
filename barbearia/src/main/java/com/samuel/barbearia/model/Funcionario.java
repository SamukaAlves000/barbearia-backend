package com.samuel.barbearia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Data
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private double salario;
    @OneToOne
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    @ManyToMany
    @JoinTable(
            name = "TB_FUNCIONARIO_SERVICO",
            joinColumns = @JoinColumn(name = "FUNCIONARIO_ID"),
            inverseJoinColumns = @JoinColumn(name = "SERVICO_ID"))
    Set<Servico> servicos;
    @JsonBackReference //OK
    @OneToMany(mappedBy="funcionario")
    Set<Atendimento> atendimentos;
}
