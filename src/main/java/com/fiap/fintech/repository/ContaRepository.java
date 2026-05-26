package com.fiap.fintech.repository;

import com.fiap.fintech.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}

