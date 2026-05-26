package com.fiap.fintech.service;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Long id) {
        super(resourceName + " com id " + id + " nao encontrado.");
    }
}

