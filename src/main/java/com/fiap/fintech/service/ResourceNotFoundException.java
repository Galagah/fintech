package com.fiap.fintech.service;

// Excecao usada quando um registro solicitado nao existe no banco.
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " com id " + id + " nao encontrado.");
    }
}

