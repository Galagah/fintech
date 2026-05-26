package com.fiap.fintech.repository;

import com.fiap.fintech.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository JPA responsavel pelo acesso aos dados de usuarios.
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

