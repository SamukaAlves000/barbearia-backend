package com.samuel.barbearia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_ATENDIMENTO")
@Data
public class Atendimento implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate data;
    private Time horario;
    private boolean status;
    private Integer avaliacao;
    private LocalDate dataAgendamento;
    @ManyToOne
    @JoinColumn(name = "PESSOA_ID",nullable = false)
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name="FUNCIONARIO_ID", nullable=false)
    private Funcionario funcionario;
    @ManyToMany
    @JoinTable(
            name = "TB_ATENDIMENTO_SERVICO",
            joinColumns = @JoinColumn(name = "ATENDIMENTO_ID"),
            inverseJoinColumns = @JoinColumn(name = "SERVICO_ID"))
    List<Servico> servicos;
}
