package com.fiap.fintech.repository;

import com.fiap.fintech.model.Investimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestimentoRepository extends JpaRepository<Investimento, Long> {
}

