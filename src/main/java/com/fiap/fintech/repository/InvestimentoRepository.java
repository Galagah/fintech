package com.fiap.fintech.repository;

import com.fiap.fintech.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository JPA responsavel pelo acesso aos dados de investimentos.
public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}

