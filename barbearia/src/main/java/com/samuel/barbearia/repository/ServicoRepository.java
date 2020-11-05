package com.samuel.barbearia.repository;

import com.samuel.barbearia.model.Funcionario;
import com.samuel.barbearia.model.Servico;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Integer> {

}
