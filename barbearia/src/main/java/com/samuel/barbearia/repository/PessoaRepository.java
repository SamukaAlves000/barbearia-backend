package com.samuel.barbearia.repository;

import com.samuel.barbearia.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Integer> {
}
