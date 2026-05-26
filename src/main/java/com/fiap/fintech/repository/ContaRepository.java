package com.fiap.fintech.repository;

import com.fiap.fintech.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository JPA responsavel pelo acesso aos dados de contas.
public interface ContaRepository extends JpaRepository<Conta, Long> {
}

