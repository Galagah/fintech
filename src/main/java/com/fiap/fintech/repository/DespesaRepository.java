package com.fiap.fintech.repository;

import com.fiap.fintech.model.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}

