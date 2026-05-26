package com.fiap.fintech.service;

import com.fiap.fintech.model.Conta;
import com.fiap.fintech.repository.ContaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public List<Conta> listar() {
        return repository.findAll();
    }

    public Conta buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Conta", id));
    }

    public Conta criar(Conta conta) {
        conta.setId(null);
        return repository.save(conta);
    }

    public Conta atualizar(Long id, Conta conta) {
        buscarPorId(id);
        conta.setId(id);
        return repository.save(conta);
    }

    public void excluir(Long id) {
        repository.delete(buscarPorId(id));
    }
}

