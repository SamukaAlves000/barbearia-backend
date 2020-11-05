package com.samuel.barbearia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_FUNCIONARIO")
@Data
public class Funcionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = true)
    private double salario;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PESSOA_ID", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "TB_FUNCIONARIO_SERVICO",
            joinColumns = @JoinColumn(name = "FUNCIONARIO_ID"),
            inverseJoinColumns = @JoinColumn(name = "SERVICO_ID"))
    private List<Servico> servicos;
    @JsonIgnore
    @OneToMany(mappedBy="funcionario")
    private List<Atendimento> atendimentos;
}
