package com.fiap.fintech.repository;

import com.fiap.fintech.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository JPA responsavel pelo acesso aos dados de despesas.
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}

