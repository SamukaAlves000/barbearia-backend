package com.samuel.barbearia.repository;

import com.samuel.barbearia.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento,Integer> {
}
