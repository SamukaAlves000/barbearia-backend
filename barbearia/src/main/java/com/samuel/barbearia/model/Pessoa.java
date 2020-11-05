package com.samuel.barbearia.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TB_PESSOA")
@Data
public class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String nome;
    private String email;
    private String telefone;
    private String cidade;
    private String uf;
    private String bairro;
    private String complemento;
    private String cpf;
    private char sexo;
    private LocalDate dataNascimento;
    private String caminhoFoto;
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private List<Atendimento> atendimentos;
    @OneToOne(mappedBy = "pessoa",cascade ={CascadeType.PERSIST,CascadeType.MERGE})
    @JsonIgnore
    private Funcionario funcionario;
}
